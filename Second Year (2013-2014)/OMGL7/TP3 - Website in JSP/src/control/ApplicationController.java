package control;

import java.util.HashMap;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author lesommer
 */
public class ApplicationController {
    private HashMap<String,UrlMapping> rules;
    private static ApplicationController controller;

   private ApplicationController(){
        this.rules = new HashMap<String,UrlMapping>();
    }

    public static ApplicationController getInstance(){
        if(controller == null){
            controller = new ApplicationController();
        }
        return controller;
    }

public void setRules(ArrayList<UrlMapping> rules){
    for(int i = 0; i < rules.size(); i++){
        this.rules.put(rules.get(i).getPattern(),rules.get(i));
    }
    
}
  
  public void processRequest(HttpServletRequest request,
                  HttpServletResponse response, ServletContext context)
    throws IOException, ServletException {

  String pattern = request.getParameter("p");

  ActionListener listener=null;
  String view="";
  UrlMapping rule = this.rules.get(pattern);

  if(rule == null){
    request.setAttribute("message","The view does not exist");
    view = this.rules.get("error").getView();
  }else {
      listener = rule.getListener();
      view = rule.getView();
  }
  
  if(listener != null){
      listener.handle(request);
  }
   
    RequestDispatcher dispatcher =  context.getRequestDispatcher(view);
      dispatcher.forward(request, response);
    }

}
