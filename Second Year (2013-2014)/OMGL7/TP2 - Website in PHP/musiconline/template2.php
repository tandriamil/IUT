<!DOCTYPE html>
<html>
    <head>
        <title></title>

    </head>
    <body>
        <div class="header">
            <?php
            echo Session::getInstance()->get('header');
            ?>
        </div>
        <div class="left_panel">
            <?php
            echo Session::getInstance()->get('left_panel');
            ?>
        </div>
        <div class="main">
            <?php
            echo Session::getInstance()->get('main');
            ?>
        </div>
        <div class="rigth_panel">
            <?php
            echo Session::getInstance()->get('rigth_panel');
            ?>
        </div>
        <div class="foot">
            <?php
            echo Session::getInstance()->get('foot');
            ?>
        </div>

    </body>
</html>
