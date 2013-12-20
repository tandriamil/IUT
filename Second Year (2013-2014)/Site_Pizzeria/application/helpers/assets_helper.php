<?php  if ( ! defined('BASEPATH')) exit('No direct script access allowed');

//Le helper pour les assets

/**
 * La fonction incluant les feuilles de styles
 */
if ( ! function_exists('css_url'))
{
	function css_url($nom)
	{
		return base_url() . 'assets/css/' . $nom . '.css';
	}
}


/**
 * La fonction incluant les scripts js
 */
if ( ! function_exists('js_url'))
{
	function js_url($nom)
	{
		return base_url() . 'assets/js/' . $nom . '.js';
	}
}


/**
 * La fonction incluant les blocs de pages
 */
if ( ! function_exists('blocs'))
{
	function blocs($nom)
	{
		return 'application/views/blocs/' . $nom . '.php';
		//Pas de base_url() car cela renvoie une erreur de php
	}
}


/**
 * La fonction incluant les urls des images
 */
if ( ! function_exists('img_url'))
{
	function img_url($nom)
	{
		return base_url() . 'assets/img/' . $nom;
	}
}


/**
 * La fonction incluant les images
 */
if ( ! function_exists('img'))
{
	function img($nom, $alt)
	{
		return '<img src="' . img_url($nom) . '" alt="' . $alt . '" />';
	}
}