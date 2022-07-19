package com.example.tbc_homework_11

import java.io.Serializable

data class Game(
    val title: String,
    val desc: String,
    var imageURL: String?,
    val hasImage: HasImage
) : Serializable

val gamesList = arrayListOf<Game>(
    Game("Witcher 2", "The Witcher 2: Assassins of Kings (Polish: Wiedźmin 2: Zabójcy królów) is a 2011 action role-playing video game developed by CD Projekt Red, based on The Witcher series of fantasy novels by Andrzej Sapkowski.", "https://s3.amazonaws.com/prod-media.gameinformer.com/styles/body_default/s3/legacy-images/imagefeed/The%20Witcher%202%20Is%20The%20Big%20New%20Xbox%20One%20Backward%20Compatible%20Game/witcher20527.jpg",
        HasImage.TRUE
    ),
    Game("Final Fantasy XV", "Final Fantasy XV is an action role-playing game developed and published by Square Enix. The fifteenth main installment of the Final Fantasy series, it was released for the PlayStation 4 and Xbox One in 2016, Microsoft Windows in 2018, and as a launch title for Stadia in 2019.", "https://images.ctfassets.net/vfkpgemp7ek3/1514343649/a49b3fa382cf409faa1a0f2992072556/final-fantasy-xv-a-new-empire-evenue-november-2018.jpg", HasImage.TRUE),
    Game("Nier Automata", "Nier: Automata is a 2017 action role-playing game developed by PlatinumGames and published by Square Enix. It is a sequel to the 2010 video game Nier, itself a spin-off and sequel of the Drakengard series.", "https://cdn.vox-cdn.com/thumbor/w5YP29h0QVGNVAJMGnuOIVjZkjo=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/23655225/ss_8b29f7e1ce9a8b9313dc3eb50dbe76a4cf94eef9.jpg" , HasImage.TRUE),
    Game("Stray", "Stray is a 2022 adventure game developed by BlueTwelve Studio and published by Annapurna Interactive. Formerly known as HK_Project, the game was released for PlayStation 4, PlayStation 5, and Windows. It follows the story of a stray cat who falls into a world populated by robots, machines and viruses and sets out to return to his family.", null, HasImage.FALSE)

)