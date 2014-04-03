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


	//Here we'll try the connection to the database
	//We can load automatically all the classes, we don't need Zend autoload for this
	/* Zend_Loader::loadClass('Zend_Config_Ini');
	Zend_Loader::loadClass('Zend_Registry');
	Zend_Loader::loadClass('Zend_Db');
	Zend_Loader::loadClass('Zend_Db_Table'); */


	//$configPath is an array here
	$configPath = '../www/config/config.ini';

	//Creates a new object from the config.ini
	$config = new Zend_Config_Ini($configPath, 'dev');

	//Builds the $db object for using the db
	$db = Zend_Db::factory($config->database);

	//getConnection() forces the adaptator to connect to the db system
	//It will return an object representing the connection in function of the php extension used, or an exception if error
	//Here we use PDO, so it'll return PDO
	$db->getConnection();

	//A registry is used to store values for all the application, so the same object will be available everywhere
	Zend_Registry::set('db', $db);

	//Default database
	Zend_Db_Table::setDefaultAdapter($db);



	//Trying to launch the application
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


/* ############################## HERE ARE THE INSTRUCTIONS ######################### */






/* ############################## END OF THOSE ######################### */

?>