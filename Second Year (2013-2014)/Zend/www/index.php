<?php

	//We define the path to our application
	define('APPLICATION_PATH', realpath(dirname( __FILE__ ) . '/../'));

	//We define the path to our library
	$library = APPLICATION_PATH . '/library';
	set_include_path($library . PATH_SEPARATOR . get_include_path());

	//The Zend_Loader_Autoloader class have methods to help us to charge files dynamically
	require_once 'Zend/Loader/Autoloader.php';
	$loader = Zend_Loader_Autoloader::getInstance();
	$loader->registerNamespace('App_');


	//We load the classes to use
	Zend_Loader::loadClass('Zend_Controller_Front');

	try {
	    //getInstance() is used to get an instance (singleton pattern) of the front controller 
		$front = Zend_Controller_Front::getInstance();
		
		//The front controller throws exceptions to the answer object in order to carry them
		$front->throwExceptions(true);
		
		//setControllerDirectory() is used to search the file classes of the action controller
		$front->setControllerDirectory(APPLICATION_PATH . '/application/controllers');
		
		//Dispatch runs our application, it does the biggest part of the front controller
		//It can take a request/answer object for the developper to provide personnalized objects
		$front->dispatch();
	}

	//Carry the controller exceptions, mostly error 404
	catch (Zend_Controller_Exception $e) {
		include 'errors/404.phtml';
	}

	//Or other exceptions
	catch (Exception $e) {
		include 'errors/500.phtml';
	}

?>