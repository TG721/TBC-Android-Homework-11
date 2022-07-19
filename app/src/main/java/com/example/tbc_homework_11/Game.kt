package com.example.tbc_homework_11

data class Game(
    val title: String,
    val desc: String,
    var resource: Int?,
    val hasImage: HasImage
)

val gamesList = arrayListOf<Game>(
    Game("Witcher 2", "The Witcher 2: Assassins of Kings (Polish: Wiedźmin 2: Zabójcy królów) is a 2011 action role-playing video game developed by CD Projekt Red, based on The Witcher series of fantasy novels by Andrzej Sapkowski.", R.drawable.witcher2,
        HasImage.TRUE
    ),
    Game("Final Fantasy XV", "Final Fantasy XV is an action role-playing game developed and published by Square Enix. The fifteenth main installment of the Final Fantasy series, it was released for the PlayStation 4 and Xbox One in 2016, Microsoft Windows in 2018, and as a launch title for Stadia in 2019.", R.drawable.ffxv, HasImage.TRUE),
    Game("Nier Automata", "Nier: Automata is a 2017 action role-playing game developed by PlatinumGames and published by Square Enix. It is a sequel to the 2010 video game Nier, itself a spin-off and sequel of the Drakengard series.", R.drawable.nier_automata , HasImage.TRUE),
    Game("Stray", "Stray is a 2022 adventure game developed by BlueTwelve Studio and published by Annapurna Interactive. Formerly known as HK_Project, the game was released for PlayStation 4, PlayStation 5, and Windows. It follows the story of a stray cat who falls into a world populated by robots, machines and viruses and sets out to return to his family.", null, HasImage.FALSE)

)