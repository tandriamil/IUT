<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title><?php echo "Error : ".$this->response->getStatus()->__toString();?></title>
    </head>
    <body>

        <h1><?php echo "Error ".$this->response->getStatus()->getCode().": ".$this->response->getStatus()->getPhrase();?></h1>

    </body>
</html>
