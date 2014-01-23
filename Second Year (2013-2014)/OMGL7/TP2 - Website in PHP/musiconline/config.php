<?php
//------------------------------------------------------------------------------
// Application name
//------------------------------------------------------------------------------
$config['app_name']="musiconline";
$config['app_url']="http//www-i.univ-ubs.fr/etud/projets/e_13_gl7_14_36/musiconline";

//------------------------------------------------------------------------------
// Debug mode
//------------------------------------------------------------------------------
$config['debug_mode']=TRUE;

//------------------------------------------------------------------------------
// Language and charset
//------------------------------------------------------------------------------
// Language can en (english), fr (french), ...
// Default language used in the Web pages 
$config['language']='fr';
$config['charset']='UTF-8';

//------------------------------------------------------------------------------
// Compress
//------------------------------------------------------------------------------
// Enables Gzip output compression for faster page loads.
$config['compress_output']=FALSE;

//------------------------------------------------------------------------------
// Database
//------------------------------------------------------------------------------
// dbType can be none, mysql or sqlite
// db_host, db_login and db_password are not required for sqlite
$config['db_type']='mysql';
$config['db_host']='wamba.univ-ubs.fr';
// if the database is a SQLite3 database, you must specify the file name
$config['db_name']='e_13_gl7_14_36';   
$config['db_login']='e_13_gl7_14_36';
$config['db_password']='pe_13_gl7_14_36p';

//------------------------------------------------------------------------------
// Template
//------------------------------------------------------------------------------
$config['webapp_template']='template2.php';

//------------------------------------------------------------------------------
// Error views
//------------------------------------------------------------------------------
$config['error_view']='musiconline/views/ErrorView.php';
$config['http_error_view']='musiconline/views/HttpError.php';

//------------------------------------------------------------------------------
// css styles
// use "," to separate the style files
//------------------------------------------------------------------------------
$config['css_styles']="css/nls_style.css";

//------------------------------------------------------------------------------
// Cookies parameters
// cookie_prefix: Set a prefix if you need to avoid collisions
// cookie_domain: Set to .your-domain.com for site-wide cookies
// cookie_path:  Typically will be a forward slash
// cookie_secure: Cookies will only be set if a secure HTTPS connection exists.
//------------------------------------------------------------------------------
$config['cookie_prefix']="musiconline_"; //should not be modified
$config['cookie_domain']="";
$config['cookie_path']="/musiconline";
$config['cookie_secure']=FALSE;

//------------------------------------------------------------------------------
// Session 
// session_expiration:      The number of SECONDS you want the session to last.
// session_expire_on_close: Whether to cause the session to expire automatically
//                          when the browser window is closed
//------------------------------------------------------------------------------
$config['session_cookie_name']="SESSION_ID"; //should not be modified
$config['session_expire_on_close'] = FALSE;
$config['session_expiration'] = 7200;

//------------------------------------------------------------------------------
// log directory
//------------------------------------------------------------------------------
$config['logdir']=APP_ROOT_DIR.'/log';
$config['log']=false;


//------------------------------------------------------------------------------
// URL mapping
//------------------------------------------------------------------------------
include_once $config['app_name']."/controllers/controllers.php";

?>

