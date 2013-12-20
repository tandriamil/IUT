<?php

/*
 *---------------------------------------------------------------
 * APPLICATION ENVIRONMENT
 *---------------------------------------------------------------
 *
 * You can load different configurations depending on your
 * current environment. Setting the environment also influences
 * things like logging and error reporting.
 *
 * This can be set to anything, but default usage is:
 *
 *     development
 *     testing
 *     production
 *
 * NOTE: If you change these, also change the error_reporting() code below
 *
 */
	define('ENVIRONMENT', 'development');
/*
 *---------------------------------------------------------------
 * ERROR REPORTING
 *---------------------------------------------------------------
 *
 * Different environments will require different levels of error reporting.
 * By default development will show errors but testing and live will hide them.
 */

if (defined('ENVIRONMENT'))
{
	switch (ENVIRONMENT)
	{
		case 'development':
			error_reporting(E_ALL);
		break;
	
		case 'testing':
		case 'production':
			error_reporting(0);
		break;

		default:
			exit('The application environment is not set correctly.');
	}
}

/*
 *---------------------------------------------------------------
 * SYSTEM FOLDER NAME
 *---------------------------------------------------------------
 *
 * This variable must contain the name of your "system" folder.
 * Include the path if the folder is not in the same  directory
 * as this file.
 *
 */
	$system_path = 'system';

/*
 *---------------------------------------------------------------
 * APPLICATION FOLDER NAME
 *---------------------------------------------------------------
 *
 * If you want this front controller to use a different "application"
 * folder then the default one you can set its name here. The folder
 * can also be renamed or relocated anywhere on your server.  If
 * you do, use a full server path. For more info please see the user guide:
 * http://codeigniter.com/user_guide/general/managing_apps.html
 *
 * NO TRAILING SLASH!
 *
 */
	$application_folder = 'application';

/*
 * --------------------------------------------------------------------
 * DEFAULT CONTROLLER
 * --------------------------------------------------------------------
 *
 * Normally you will set your default controller in the routes.php file.
 * You can, however, force a custom routing by hard-coding a
 * specific controller class/function here.  For most applications, you
 * WILL NOT set your routing here, but it's an option for those
 * special instances where you might want to override the standard
 * routing in a specific front controller that shares a common CI installation.
 *
 * IMPORTANT:  If you set the routing here, NO OTHER controller will be
 * callable. In essence, this preference limits your application to ONE
 * specific controller.  Leave the function name blank if you need
 * to call functions dynamically via the URI.
 *
 * Un-comment the $routing array below to use this feature
 *
 */
	// The directory name, relative to the "controllers" folder.  Leave blank
	// if your controller is not in a sub-folder within the "controllers" folder
	// $routing['directory'] = '';

	// The controller class file name.  Example:  Mycontroller
	// $routing['controller'] = '';

	// The controller function you wish to be called.
	// $routing['function']	= '';


/*
 * -------------------------------------------------------------------
 *  CUSTOM CONFIG VALUES
 * -------------------------------------------------------------------
 *
 * The $assign_to_config array below will be passed dynamically to the
 * config class when initialized. This allows you to set custom config
 * items or override any default config values found in the config.php file.
 * This can be handy as it permits you to share one application between
 * multiple front controller files, with each file containing different
 * config values.
 *
 * Un-comment the $assign_to_config array below to use this feature
 *
 */
	// $assign_to_config['name_of_config_item'] = 'value of config item';



// --------------------------------------------------------------------
// END OF USER CONFIGURABLE SETTINGS.  DO NOT EDIT BELOW THIS LINE
// --------------------------------------------------------------------

/*
 * ---------------------------------------------------------------
 *  Resolve the system path for increased reliability
 * ---------------------------------------------------------------
 */

	// Set the current directory correctly for CLI requests
	if (defined('STDIN'))
	{
		chdir(dirname(__FILE__));
	}

	if (realpath($system_path) !== FALSE)
	{
		$system_path = realpath($system_path).'/';
	}

	// ensure there's a trailing slash
	$system_path = rtrim($system_path, '/').'/';

	// Is the system path correct?
	if ( ! is_dir($system_path))
	{
		exit("Your system folder path does not appear to be set correctly. Please open the following file and correct this: ".pathinfo(__FILE__, PATHINFO_BASENAME));
	}

/*
 * -------------------------------------------------------------------
 *  Now that we know the path, set the main path constants
 * -------------------------------------------------------------------
 */
	// The name of THIS file
	define('SELF', pathinfo(__FILE__, PATHINFO_BASENAME));

	// The PHP file extension
	// this global constant is deprecated.
	define('EXT', '.php');

	// Path to the system folder
	define('BASEPATH', str_replace("\\", "/", $system_path));

	// Path to the front controller (this file)
	define('FCPATH', str_replace(SELF, '', __FILE__));

	// Name of the "system folder"
	define('SYSDIR', trim(strrchr(trim(BASEPATH, '/'), '/'), '/'));


	// The path to the "application" folder
	if (is_dir($application_folder))
	{
		define('APPPATH', $application_folder.'/');
	}
	else
	{
		if ( ! is_dir(BASEPATH.$application_folder.'/'))
		{
			exit("Your application folder path does not appear to be set correctly. Please open the following file and correct this: ".SELF);
		}

		define('APPPATH', BASEPATH.$application_folder.'/');
	}

/*
 * --------------------------------------------------------------------
 * LOAD THE BOOTSTRAP FILE
 * --------------------------------------------------------------------
 *
 * And away we go...
 *
 */
require_once BASEPATH.'core/CodeIgniter.php';

/* End of file index.php */
/* Location: ./index.php */

/*
#########################################################################################################
*/

/* Ici il y aura mon tuto sur ce framework

Notes :
	- Il y souvent des erreurs à cause des droits, mettez vous donc à la racine de votre dossier Web et faites un chmod -R 777 * (mettra tous les droits à tout le monde à tous les sous-dossiers).



Configuration :
	- URL de base et cryptage de sessions à renseigner dans application/config/config.php.
		$config['base_url'] = "http://localhost/codeIgniter/";

	- La base de données à renseigner dans application/config/database.php.
		$db['default']['hostname'] = "nom_d_hote";
		$db['default']['username'] = "nom_d_utilisateur";
		$db['default']['password'] = "mot_de_passe";
		$db['default']['database'] = "base_de_donnees";

	- On peut utiliser plusieurs bases, ici c'est que défaut qui sera utilisée

	- Pour cacher le index.php, créer le fichier .htaccess avec:
		#   Empêche la visualisation de l'arborescence, n'a rien à voir avec le masquage du « index.php ».
		Options -Indexes

		#   Active le module de réécriture d'URL.
		RewriteEngine on

		#
		#   Fixe les règles de réécriture d'URL. Ici, nous utilisons une liste blanche.
		#

		#   Toutes les URL qui ne correspondent pas à ces masques sont réécrites.
		RewriteCond $1 !^(index\.php|assets/|robots\.txt)

		#   Toutes les autres URL vont être redirigées vers le fichier index.php.
		RewriteRule ^(.*)$ index.php/$1 [L]

	- Et ensuite, remodifier le fichier config.php
		//    Dans le cas où mod_rewrite est activé
		$config['index_page'] = "";

		//    Dans le cas contraire
		$config['index_page'] = "index.php";

	- URL suffix pour mettre un ptit suffix  :)
		$config['url_suffix'] = ".html";

	- Et aussi le langage  :)
		$config['language'] = "french";



Paramètrages des variables sessions:
	- Créer une table via le .sql suivant:
		CREATE TABLE IF NOT EXISTS `ci_sessions` (
			session_id      varchar(40)    DEFAULT '0' NOT NULL,
			ip_address      varchar(16)    DEFAULT '0' NOT NULL,
			user_agent      varchar(120)   NOT NULL,
			last_activity   int(10)        unsigned DEFAULT 0 NOT NULL,
			user_data       text           NOT NULL,

			PRIMARY KEY (session_id),

			KEY `last_activity_idx` (`last_activity`)
		);

	- Et modifier les lignes suivantes de config.php
		//    La valeur TRUE permet d'utiliser la base de données
			$config['sess_use_database'] = TRUE;

			//    Le nom de la table
			$config['sess_table_name'] = 'ci_sessions';



Le fichier autoload.php:
	- Permet de pouvoir lancer automatiquement des librairies
		$autoload['libraries'] = array('database', 'session'); => Ces deux là étants beaucoup utilisées

	- De même pour les helpers:
		$autoload['helper'] = array('url');



Les URLs : Ou plutôt ici des URIs
	- Du type example.com/class/function/ID  (ex : example.com/news/article/my_article)

//Suppléments
	- index.php s’y insère souvent, pour éviter cela on peut rajouter ces lignes au .htaccess :
		RewriteEngine on
		RewriteCond $1 !^(index\.php|images|robots\.txt)
		RewriteRule ^(.*)$ /index.php/$1 [L]
	- On peut ajouter un suffixe à tous les URLs dans config/config.php.
	- Activer les URLs avec requête dans application/config.php :
		$config['enable_query_strings'] = FALSE;  => Passer à true
	- Attention ! Dans ce cas là, on doit REFAIRE tous nos URLs.



Les Controleurs :
	- Une classe nommée de manière à être chargée avec une URI.
		Ex : example.com/index.php/blog/ appellera la classe blog.php situé dans application/controllers.
	- Les classes devront extends Controller
	- Le constructeur, s’il y en a un, doit toujours appeler parent::Controller();

	- Si par la suite on aura des pages réservées à l'admin, on utilisera:
		public function __construct()
		{
			//	Obligatoire
			parent::__construct();
	 
			if( ! isAdmin())
				exit("Vous n'avez pas le droit de voir cette page.");
		}
	
//Suppléments
	- On peut définir un controleur par défaut si non présent, modifier le fichier application/config/routes.php et changer la ligne $route['default_controller'] = 'ParDefaut';
	- On peut faire des redirections avec _remap(), cf le site



Les Fonctions :
	- Le deuxième champ d’un URI est la fonction appelée ! (Par défaut c’est index() …)
	- Donc l’URI choppe la classe, puis le champ à exécuté
	- Une fonction peut être rendue privée et inaccessible par l’URI en mettant un underscore devant

	- La fonction _output() permet de modifier une dernière fois les données avant de les envoyer au navigateur:
		//	L'affichage de la variable $output est le comportement par défaut.
		public function _output($output)
		{
			var_dump($output);
		}

	- La fonction _remap() permet de TOUT rediriger
		public function _remap($method)
		{
			$this->maintenance();
		}

	- La fonction show_404() affiche la page 404
	


Les paramètres :
	- Tous les champs au dela de la fonction seront les paramètres associées à cette fonction
	- On peut forcer un affichage, pour cela on utilise la fonction _output(), pour définir la vue. Cette dernière sera appelée avec comme paramètre la vue à afficher.

	- Pour ajouter des variables _GET aux fonctions:
		//	Cette page accepte deux variables $_GET facultatives
		public function manger($plat = '', $boisson = '')
		{
			echo 'Voici votre menu : <br />';
			echo $plat . '<br />';
			echo $boisson . '<br />';
			echo 'Bon appétit !';
		}



Les vues :
	- Appelés à partir d’un contrôleur et situés dans application/views
	- Pour charger une vue, utiliser $this->load->view('uneVue');  //Pas besoin de mettre de .php
	- Possibiligé des les rangers dans des sous-dossiers $this->load->view('dossier/uneVue');
	
	- On peut ajouter des données à transmettre à la vue, comme un objet ou un array
		$data = new Someclass();
		$this->load->view('blogview', $data);
	OU
		function index() {
			$data['title'] = "My Real Title";
			$data['heading'] = "My Real Heading";
			$this->load->view('blogview', $data);
		}

	- On les récupère ensuite avec :
		<body>
			<h1>
				<?php echo $heading;?>
			</h1>
		</body>

	- Ou encore mieux si on récupère un array après une requête sur une BDD :
		<ul>
			<?php foreach($todo_list as $item):?>
			<li>
				<?php echo $item;?>
			</li>
			<?php endforeach;?>
		</ul>

	- On peut aussi récupérer la page en tant que texte, suffit de mettre true en troisième paramètre
		$string = $this->load->view('myfile', '', true);
	


Les modèles :
	- On les retrouve dans application/models/
	- On peut les inclure dans un controlleur avec $this->load->model('blog/queries');
	- Et après accéder à la fonction désirée via $this->Model_name->function();
	- Pour changer le nom de l'objet et l'utiliser avec ce nouveau nom
		$this->load->model('Model_name', 'fubar');
		$this->fubar->function();
	- Exemple complet:
		class Blog_controller extends Controller {

    function blog()
    {
        $this->load->model('Blog');

        $data['query'] = $this->Blog->get_last_ten_entries();

        $this->load->view('blog', $data);
    }



Les helpers:
	- Permettent d'utiliser des fonctions intégrées

	- Le helper url permet de créer ses urls dans son site:
		$this->load->helper('url'); => Charge le helper mais chargé automatiquement dans autoload.php donc pas besoin

	- Les différentes manières de l'utiliser:
		<p>
			<a href="<?php echo site_url(); ?>">accueil</a>
			<br />
			
			<a href="<?php echo site_url('test'); ?>">accueil</a> du test
			<br />
			
			<a href="<?php echo site_url('test/secret'); ?>">page secrète</a>
			<br />
			
			<a href="<?php echo site_url(array('test', 'secret')); ?>">page secrète</a>
		</p>

	- Redirect fait la même chose globalement mais en location:
		{
			redirect(array('error', 'probleme'));
		}

	- base_url renvoie l'url actuel

	- Si l'on veut rajouter/modifier un helper de base du système de CI:
		- $config['subclass_prefix'] = 'MY_';  => Dans config.php, indique le préfix des classes refaites
		- Appeler le nouveau fichier MY_url_helper.php
		- Modifiera uniquement une ou plusieurs fonctions et laissera les autres tels quels
		- Ne pas modifier directement les helpers de system/helpers!



Les Bibliothèques:
	- Charger la/les bibliothèques:	
		$this->load->library('nom_de_la_bibliothèque');
	- On peut faire de même dans autoload.php bien sur

	- Quand on fait un $this-load->uneFon(), on fait appel à la bibliothèque load!

	- La bibliothèque session de CI est bien mieux que la native de php:
		- CI assigne un n° à chaque utilisateur du site, régénéré toutes les 5 minutes
		- $session_id = $this->session->userdata('session_id');  => Récup de cet id

		- 3 autres méthodes disponibles:
			- $adresse_ip               = $this->session->userdata('ip_address');
			- $user_agent_du_navigateur = $this->session->userdata('user_agent');
			- $derniere_visite          = $this->session->userdata('last_activity');

		- On peut aussi y ajouter ses propres données à sauvegarder:
			- $this->session->set_userdata('nom_de_votre_valeur', 'valeur');  => Les sauvegarde
			- Retourne false si la valeur n'existe pas

		- Pour supprimer des éléments de session
			- $this->session->unset_userdata(array('pseudo' => '', 'email' => ''));

		- Pour carrément supprimer toute la session d'un user:
			- $this->session->sess_destroy();

	- Une autre bibliothèque est celle gérant les formulaires et leurs vérifs:
		- $this->load->library('form_validation');

		- Utilisation dans un controleur:
		//	Chargement de la bibliothèque
		$this->load->library('form_validation');
		
		if($this->form_validation->run())
		{
			//	Le formulaire est valide
			$this->load->view('connexion_reussi');
		}
		else
		{
			//	Le formulaire est invalide ou vide
			$this->load->view('formulaire');
		}

		- Pour définir les règles des champs, on utilise set_rules($nomChamp, $nomHumain, $chaineCharRules):
			$this->form_validation->set_rules('pseudo', '"Nom d\'utilisateur"', 'trim|required|min_length[5]|max_length[52]|alpha_dash|encode_php_tags|xss_clean');
			$this->form_validation->set_rules('mdp',    '"Mot de passe"',       'trim|required|min_length[5]|max_length[52]|alpha_dash|encode_php_tags|xss_clean');

		- Récupération des valeurs via la librairie input:
			- $pseudo = $this->input->post('pseudo');
			- $mdp = $this->input->post('mdp');

		- Affichage des erreurs et remplissage des champs qui ont été déjà remplies:
			<form method="post" action="">
				<label for="pseudo">Pseudo : </label>
				<input type="text" name="pseudo" value="<?php echo set_value('pseudo'); ?>" />
				<?php echo form_error('pseudo'); ?>

				<label for="mdp">Mot de passe :</label>
				<input type="password" name="mdp" value="" />
				<?php echo form_error('mdp'); ?>

				<input type="submit" value="Envoyer" />
			</form>

	- Une dernière biliothèque gère les BDD:
		- $this->load->database();

		- Un exemple d'utilisation:
			$resultat = $this->db->select('id, email')
			                     ->from('utilisateurs')
			                     ->where('pseudo', 'ChuckNorris')
			                     ->limit(1)
			                     ->get()
			                     ->result();

		- Pour les plus longues:
			//	Mise en place de notre requête
			$sql = "SELECT	`id`,
					`email`
				FROM	`utilisateurs`
				WHERE	`pseudo` = ?
				LIMIT	0,1
			     ;";

			// Les valeurs seront automatiquement échappées
			$data = array('ChuckNorris');

			//	On lance la requête
			$query = $this->db->query($sql, $data);

			//	On récupère le nombre de résultats
			$nb_resultat = $query->num_rows();

			//	On parcourt l'ensemble des résultats
			foreach($query->result() as $ligne)
			{
				echo $ligne->id;
			}

			//	On libère la mémoire de la requête (fortement conseillé pour lancer une seconde requête)
			$query->free_result();

		- $CI = get_instance(); permet de récupérer l'instance du singleton CI, pour faire appel à ce qu'on veut depuis une fonction




Les modèles:
	- Il faut d'abord les charger dans le controlleur:
		$this->load->model('news_model');

	- Récupération des infos depuis la bdd:
		//	Chargement du modèle de gestion des news
		$this->load->model('news_model');

		$data = array();

		//	On lance une requête
		$data['user_info'] = $this->news_model->get_info();

		//	On inclut une vue
		$this->layout->view('ma_vue', $data);

	- On peut aussi renommer le modèle:
		$this->load->model('nom_du_fichier', 'nom_a_donner');

	- Exemple d'une fonction dans un modèle:
		public function ajouter_news($auteur, $titre, $contenu)
		{
			//	Ces données seront automatiquement échappées
			$this->db->set('auteur',  $auteur);
			$this->db->set('titre',   $titre);
			$this->db->set('contenu', $contenu);
			
			//	Ces données ne seront pas échappées
			$this->db->set('date_ajout', 'NOW()', false);
			$this->db->set('date_modif', 'NOW()', false);
			
			//	Une fois que tous les champs ont bien été définis, on "insert" le tout
			return $this->db->insert($this->table);
		}
		- Ici, le nom de la table utilisée est enregistrée dans:
			protected $table = 'news';

	- Exemple d'utilisation de cette méthode:
		$resultat = $this->newsManager->ajouter_news('Arthur',
						     'Un super titre',
						     'Un super contenu !');
		var_dump($resultat);

	- On peut aussi faire de cette manière:
		return $this->db->set('auteur',	 $auteur)
			->set('titre', 	 $titre)
			->set('contenu', $contenu)
			->set('date_ajout', 'NOW()', false)
			->set('date_modif', 'NOW()', false)
			->insert($this->table);

	- Une méthode de modification:
		public function editer_news($id, $titre = null, $contenu = null)
	{
		//	Il n'y a rien à éditer
		if($titre == null AND $contenu == null)
		{
			return false;
		}
		
		//	Ces données seront échappées
		if($titre != null)
		{
			$this->db->set('titre', $titre);
		}
		if($contenu != null)
		{
			$this->db->set('contenu', $contenu);
		}
		
		//	Ces données ne seront pas échappées
		$this->db->set('date_modif', 'NOW()', false);
		
		//	La condition
		$this->db->where('id', (int) $id);
		
		return $this->db->update($this->table);
	}

	- Une méthode de suppression:
		public function supprimer_news($id)
		{
			return $this->db->where('id', (int) $id)
					->delete($this->table);
		}

	- Une méthode de comptage:
		public function count($where = array())
		{
			return (int) $this->db->where($where)
					      ->count_all_results($this->table);
		}



Le profiler:
	- Permet d'obtenir des indices de performances de notre appli
	- Pour l'activer dans un controlleur:
		$this->output->enable_profiler(true);

	- Pour tester quelle est la méthode la plus rapide:
		public function index()
		{
			//	Première requête
			$this->benchmark->mark('requete1_start');
			$query = $this->db->query('SELECT `id`, `username`, `user_rank` FROM `users`')->result();
			$this->benchmark->mark('requete1_end');
			
			//	Deuxième requête
			$this->benchmark->mark('requete2_start');
			$query = $this->db->select('id, username, user_rank')->from('users')->get()->result();
			$this->benchmark->mark('requete2_end');
	 
			$this->output->enable_profiler(true);
		}

	- Pour récup les résultats du test:
		$this->benchmark->elapsed_time('requete1_start', 'requete1_end');

	- Pour réécrire un profiler:
		class CI_Profiler {

			var $CI;
		 	
		 	function CI_Profiler();
		 	
			// --------------------------------------------------------------------

		 	function _compile_benchmarks();
			function _compile_queries();
			function _compile_get();
			function _compile_post();
			function _compile_uri_string();
			function _compile_controller_info();
			function _compile_memory_usage();

			// --------------------------------------------------------------------
			
			function run();
		}

	- La fonction run():
		class MY_Profiler extends CI_Profiler
		{	
			function run()
			{
				$output = "<div id='codeigniter_profiler' style='clear:both;background-color:#fff;padding:10px;'>";

				$output .= $this->_compile_uri_string();
				$output .= $this->_compile_get();
				$output .= $this->_compile_post();
				$output .= $this->_compile_controller_info();
				$output .= $this->_compile_benchmarks();
				$output .= $this->_compile_queries();
				$output .= $this->_compile_memory_usage();
				$output .= $this->_compile_session();

				$output .= '</div>';
				
				return $output;
			}
		}

	- On peut donc rajouter une ligne pour les sessions:


	- La méthode pour ajouter les sessions:
		function _compile_session()
		{
			$output  = "\n\n";
			$output .= '<fieldset style="border:1px solid #009999;padding:6px 10px 10px 10px;margin:20px 0 20px 0;background-color:#eee">';
			$output .= "\n";

			$output .= '<legend style="color:#009999;">&nbsp;&nbsp;' . 'DONNEES SESSION' . '&nbsp;&nbsp;</legend>';
			$output .= "\n";

			if(is_object($this->CI->session))
			{
				//	Le contenu de la session
					
			}
			else
			{
				//	La session est indéfinie
				$output .= "<div style='color:#009999;font-weight:normal;padding:4px 0 4px 0'>".'No SESSION data exists'."</div>";
			}

			return $output . "</fieldset>";
		}

	- Ou même via un tableau!
		function _compile_session()
		{
			$output  = "\n\n";
			$output .= '<fieldset style="border:1px solid #009999;padding:6px 10px 10px 10px;margin:20px 0 20px 0;background-color:#eee">';
			$output .= "\n";

			$output .= '<legend style="color:#009999;">&nbsp;&nbsp;' . 'DONNEES SESSION' . '&nbsp;&nbsp;</legend>';
			$output .= "\n";

			if(is_object($this->CI->session))
			{
				//	Le contenu de la session
				$output .= "\n\n<table cellpadding='4' cellspacing='1' border='0' width='100%'>\n";
					
				//	Nous devons exécuter cette fonction pour récupérer un tableau de valeurs
				//	En effet, pour accéder aux données de la session, il faut récupérer ses attributs
				$sess = get_object_vars($this->CI->session);

				//	Nous parcourons chaque valeur du tableau de sessions
				foreach($sess['userdata'] as $key => $val)
				{
					//	On échappe (juste pour l'affichage) les données non numériques et on les affiche
					if( ! is_numeric($key))
					{
						$key = "'" . $key . "'";
					}
					$output .= "<tr><td width='50%' style='color:#000; background-color:#ddd;'>&#36;_SESSION[" . $key . "]&nbsp;&nbsp; </td><td width='50%' style='color:#009999;font-weight:normal;background-color:#ddd;'>";

					//	On affiche la valeur de la variable. Si c'est un tableau, on exécute la fonction print_r
					if(is_array($val))
					{
						$output .= "<pre>" . htmlspecialchars(stripslashes(print_r($val, true))) . "</pre>";
					} 
					else
					{
						$output .= htmlspecialchars(stripslashes($val));
					}

					$output .= "</td></tr>\n";
				}

				$output .= "</table>\n";
			}
			else
			{
				//	La session est indéfinie
				$output .= "<div style='color:#009999;font-weight:normal;padding:4px 0 4px 0'>".'No SESSION data exists'."</div>";
			}

			return $output . "</fieldset>";
		}


}