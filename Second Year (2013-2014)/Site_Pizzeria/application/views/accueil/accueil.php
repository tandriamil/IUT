<!DOCTYPE php>

<html lang="fr">

<head>
  <title><?php echo $titre; ?></title>
  <link rel="stylesheet" href= <?php echo css_url('style'); ?> />  <!-- Pour spécifier l'emplacement du css -->
  <link rel="icon" type="image/png" href= <?php echo img_url('favicon.ici'); ?> />  <!-- Pour spécifier l'icone dans la barre d'url -->
  <link href='http://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'><meta charset="utf-8" />  <!-- Pour spécifier les caractères utilisées -->
</head>

<body>
  <div id="pageEntiere">  <!-- Une seule division pour englober la page! -->

  <!-- L'en-tête -->
  <?php include(blocs("header")); ?>
    
    
  <!-- Le menu -->
  <?php include(blocs("menu")); ?>


  <!-- Le menu de gauche -->
  <?php include(blocs("menuGauche")); ?>
  

  <!-- Le corps -->
  <h1>
    Welcome!
  </h1>

  <!-- Le pied de page -->
  <?php include(blocs("footer")); ?>
  
</div>
</body>

</html>