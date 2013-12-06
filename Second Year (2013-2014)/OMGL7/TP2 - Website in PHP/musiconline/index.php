<?php
//-----------------------------------------------------------------------------
// Copyright (c) 2009-2013 Université de Bretagne Sud, France.
// PHPEns is free software; you can redistribute it and/or modify it under the
// terms of the CeCILL License. See CeCILL License for more details.
//
// PHPEns is distributed in the hope that it will be useful, but WITHOUT ANY
// WARRANTY.
// This file is a part of the PHPEns project.
//
// Author: Nicolas Le Sommer
// Version: 1.2
//
// Note: This file must not be modified
//-----------------------------------------------------------------------------

//-----------------------------------------------------------------------------
// Definition of constants
//-----------------------------------------------------------------------------

define("CLASSPATH", '.:..:/amd/ladyburn/ubs/ladyburn/projets.2/e_13_gl7_14_36/private_html', true);
define("APP_ROOT_DIR",getcwd(),true);

//-----------------------------------------------------------------------------
// Include files
//-----------------------------------------------------------------------------

include_once '/amd/ladyburn/ubs/ladyburn/projets.2/e_13_gl7_14_36/private_html/phpens/framework/util/import.php';

// framework classes and interfaces
import ('phpens.framework.*');

import ('musiconline.*');
import ('musiconline.views.*');
import ('musiconline.controllers.*');
import ('musiconline.db.*');

//creates a session or resumes the current one based on the current session
//identifier specified in the request.
$session=Session::getInstance();
$session->start();

//-----------------------------------------------------------------------------
// Initialisation of the application (initialisation of the controller)
//-----------------------------------------------------------------------------
if($session->get('application')==null) {
    $application = Application::getInstance();
    $session->put('application',$application);
    $ctrl =  $application->getController();
}else {
    $application = $session->get('application');
    $ctrl =  $application->getController();
}

//-----------------------------------------------------------------------------
// Request management
//-----------------------------------------------------------------------------

$request = new Request($_REQUEST,$_COOKIE);
$response = new Response($request->getProtocol());
$ctrl->handle($request,$response);

//-----------------------------------------------------------------------------
// Display the main web page using a template
//-----------------------------------------------------------------------------

// HTTP Status line
header($response->getStatus()->__toString(), true, $response->getStatus()->getCode());

// HTTP headers
foreach ($response->getHeaders() as $header => $value){
	header($header.": ".$value);
}

// Cookies
$cookies = $response->getCookies();
$val = array_values($cookies);
for ($i = 0; $i < count($val); $i++){
  setcookie($val[$i]->getName(),$val[$i]->getValue(),$val[$i]->getDate());
}

// Content
echo $response->getContent()->getContent();

$session->put('application',$application);

?>
