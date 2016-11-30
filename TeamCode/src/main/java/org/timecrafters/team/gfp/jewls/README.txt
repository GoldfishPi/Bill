
           8 8888 8 8888888888 `8.`888b                 ,8' 8 8888           d888888o.
           8 8888 8 8888        `8.`888b               ,8'  8 8888         .`8888:' `88.
           8 8888 8 8888         `8.`888b             ,8'   8 8888         8.`8888.   Y8
           8 8888 8 8888          `8.`888b     .b    ,8'    8 8888         `8.`8888.
           8 8888 8 888888888888   `8.`888b    88b  ,8'     8 8888          `8.`8888.
           8 8888 8 8888            `8.`888b .`888b,8'      8 8888           `8.`8888.
88.        8 8888 8 8888             `8.`888b8.`8888'       8 8888            `8.`8888.
`88.       8 888' 8 8888              `8.`888`8.`88'        8 8888        8b   `8.`8888.
  `88o.    8 88'  8 8888               `8.`8' `8,`'         8 8888        `8b.  ;8.`8888
    `Y888888 '    8 888888888888        `8.`   `8'          8 888888888888 `Y8888P ,88P'


Jewls is the package for the time crafter's 2016-2017 robot.

->Engines
    -This is where all engines or runtimes should be kept. everything in here should inherit Engine from the timecrafters.engine.Engine
->States
    -This is where all the staes which get compiled into the engines are held. Everything within here should inherit timecrafters.engine.State
    ->drive
        -All states concerning the drive train should be kept in this package
    ->logic
        -All states concerning logic(i.e comparing multiple states) should be contained in this package.
    ->sensors
        -All states containing senosrs excluding encoders is contained in this package.
    ->wich
        -All states containing the winch sistem and the skythes are contained in tis package.
