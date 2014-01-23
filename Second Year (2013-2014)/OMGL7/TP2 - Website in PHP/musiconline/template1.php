<?php 
import('phpens.framework.Template');
import('phpens.framework.Application');
import('phpens.framework.html.*');

$page = new Page();
$page->setTitle(Application::getInstance()->getName());
$page->addCSSFiles(Application::getInstance()->getCSSStyles());

$divHeader=new Division();
$divHeader->setClass("header");

$divLeftPanel=new Division();
$divLeftPanel->setClass("left_panel");

$divMain=new Division();
$divMain->setClass("main");


$divRightPanel=new Division();
$divRightPanel->setClass("right_panel");

$divfoot=new Division();
$divfoot->setClass("foot");

$page->addElement($divHeader);
$page->addElement($divLeftPanel);
$page->addElement($divMain);
$page->addElement($divRightPanel);
$page->addElement($divfoot);

?>

