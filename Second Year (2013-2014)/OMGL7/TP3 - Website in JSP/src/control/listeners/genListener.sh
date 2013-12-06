cat << EOF > $1.java
package control.listeners;

import javax.servlet.http.*;
import db.*;
import control.*;

public class $1 implements ActionListener {

  public void handle(HttpServletRequest request){

    request.setAttribute("data", "$1");
  }
  
}

EOF

