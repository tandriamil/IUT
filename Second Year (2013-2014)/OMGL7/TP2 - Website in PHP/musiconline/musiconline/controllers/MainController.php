<?php
/* Authors: ANDRIAMILANTO Tompoariniaina && CANNO Camille
* Groupe: B1
* File: MainController.php
*/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import('phpens.framework.Controller');
import('phpens.framework.Request');
import('phpens.framework.Response');
import('phpens.framework.View');
/**
 * Description of TestListener
 *
 * @author lesommer
 */
class MainController extends Controller {

    public function __construct(Request $request, Response $response, View $view) {
        parent::__construct($request, $response, $view);
    }

    // Request Mapping: welcome
    public function handle(){
    	$this->view->setContent('musiconline/views/MainView.php');
    }
}
?>
