package me.uncookie.features

import me.uncookie.Uhluhtc
import me.uncookie.Uhluhtc.logger
import net.mamoe.mirai.utils.info
import org.jsoup.Jsoup
import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import javax.imageio.ImageIO

object Tiles {
    private val tileMap366 = listOf(
        "giant ant",
        "killer bee",
        "soldier ant",
        "fire ant",
        "giant beetle",
        "queen bee",
        "acid blob",
        "quivering blob",
        "gelatinous cube",
        "chickatrice",
        "cockatrice",
        "pyrolisk",
        "jackal",
        "fox",
        "coyote",
        "werejackal",
        "little dog",
        "dingo",
        "dog",
        "large dog",
        "wolf",
        "werewolf",
        "winter wolf cub",
        "warg",
        "winter wolf",
        "hell hound pup",
        "hell hound",
        "Cerberus",
        "gas spore",
        "floating eye",
        "freezing sphere",
        "flaming sphere",
        "shocking sphere",
        "beholder",
        "kitten",
        "housecat",
        "jaguar",
        "lynx",
        "panther",
        "large cat",
        "tiger",
        "gremlin",
        "gargoyle",
        "winged gargoyle",
        "hobbit",
        "dwarf",
        "bugbear",
        "dwarf lord",
        "dwarf king",
        "mind flayer",
        "master mind flayer",
        "manes",
        "homunculus",
        "imp",
        "lemure",
        "quasit",
        "tengu",
        "blue jelly",
        "spotted jelly",
        "ochre jelly",
        "kobold",
        "large kobold",
        "kobold lord",
        "kobold shaman",
        "leprechaun",
        "small mimic",
        "large mimic",
        "giant mimic",
        "wood nymph",
        "water nymph",
        "mountain nymph",
        "goblin",
        "hobgoblin",
        "orc",
        "hill orc",
        "Mordor orc",
        "Uruk-hai",
        "orc shaman",
        "orc-captain",
        "rock piercer",
        "iron piercer",
        "glass piercer",
        "rothe",
        "mumak",
        "leocrotta",
        "wumpus",
        "titanothere",
        "baluchitherium",
        "mastodon",
        "sewer rat",
        "giant rat",
        "rabid rat",
        "wererat",
        "rock mole",
        "woodchuck",
        "cave spider",
        "centipede",
        "giant spider",
        "scorpion",
        "lurker above",
        "trapper",
        "pony",
        "white unicorn",
        "gray unicorn",
        "black unicorn",
        "horse",
        "warhorse",
        "fog cloud",
        "dust vortex",
        "ice vortex",
        "energy vortex",
        "steam vortex",
        "fire vortex",
        "baby long worm",
        "baby purple worm",
        "long worm",
        "purple worm",
        "grid bug",
        "xan",
        "yellow light",
        "black light",
        "zruty",
        "couatl",
        "Aleax",
        "Angel",
        "ki-rin",
        "Archon",
        "bat",
        "giant bat",
        "raven",
        "vampire bat",
        "plains centaur",
        "forest centaur",
        "mountain centaur",
        "baby gray dragon",
        "baby silver dragon",
        "baby shimmering dragon",
        "baby red dragon",
        "baby white dragon",
        "baby orange dragon",
        "baby black dragon",
        "baby blue dragon",
        "baby green dragon",
        "baby yellow dragon",
        "gray dragon",
        "silver dragon",
        "shimmering dragon",
        "red dragon",
        "white dragon",
        "orange dragon",
        "black dragon",
        "blue dragon",
        "green dragon",
        "yellow dragon",
        "stalker",
        "air elemental",
        "fire elemental",
        "earth elemental",
        "water elemental",
        "lichen",
        "brown mold",
        "yellow mold",
        "green mold",
        "red mold",
        "shrieker",
        "violet fungus",
        "gnome",
        "gnome lord",
        "gnomish wizard",
        "gnome king",
        "giant",
        "stone giant",
        "hill giant",
        "fire giant",
        "frost giant",
        "ettin",
        "storm giant",
        "titan",
        "minotaur",
        "jabberwock",
        "vorpal jabberwock",
        "Keystone Kop",
        "Kop Sergeant",
        "Kop Lieutenant",
        "Kop Kaptain",
        "lich",
        "demilich",
        "master lich",
        "arch-lich",
        "kobold mummy",
        "gnome mummy",
        "orc mummy",
        "dwarf mummy",
        "elf mummy",
        "human mummy",
        "ettin mummy",
        "giant mummy",
        "red naga hatchling",
        "black naga hatchling",
        "golden naga hatchling",
        "guardian naga hatchling",
        "red naga",
        "black naga",
        "golden naga",
        "guardian naga",
        "ogre",
        "ogre lord",
        "ogre king",
        "gray ooze",
        "brown pudding",
        "green slime",
        "black pudding",
        "quantum mechanic",
        "rust monster",
        "disenchanter",
        "garter snake",
        "snake",
        "water moccasin",
        "python",
        "pit viper",
        "cobra",
        "troll",
        "ice troll",
        "rock troll",
        "water troll",
        "Olog-hai",
        "umber hulk",
        "vampire",
        "vampire lord",
        "vampire mage",
        "Vlad the Impaler",
        "barrow wight",
        "wraith",
        "Nazgul",
        "xorn",
        "monkey",
        "ape",
        "owlbear",
        "yeti",
        "carnivorous ape",
        "sasquatch",
        "kobold zombie",
        "gnome zombie",
        "orc zombie",
        "dwarf zombie",
        "elf zombie",
        "human zombie",
        "ettin zombie",
        "ghoul",
        "giant zombie",
        "skeleton",
        "straw golem",
        "paper golem",
        "rope golem",
        "gold golem",
        "leather golem",
        "wood golem",
        "flesh golem",
        "clay golem",
        "stone golem",
        "glass golem",
        "iron golem",
        "human",
        "wererat",
        "werejackal",
        "werewolf",
        "elf",
        "Woodland-elf",
        "Green-elf",
        "Grey-elf",
        "elf-lord",
        "Elvenking",
        "doppelganger",
        "shopkeeper",
        "guard",
        "prisoner",
        "Oracle",
        "aligned priest",
        "high priest",
        "soldier",
        "sergeant",
        "nurse",
        "lieutenant",
        "captain",
        "watchman",
        "watch captain",
        "Medusa",
        "Wizard of Yendor",
        "Croesus",
        "Charon",
        "ghost",
        "shade",
        "water demon",
        "succubus",
        "horned devil",
        "incubus",
        "erinys",
        "barbed devil",
        "marilith",
        "vrock",
        "hezrou",
        "bone devil",
        "ice devil",
        "nalfeshnee",
        "pit fiend",
        "sandestin",
        "balrog",
        "Juiblex",
        "Yeenoghu",
        "Orcus",
        "Geryon",
        "Dispater",
        "Baalzebub",
        "Asmodeus",
        "Demogorgon",
        "Death",
        "Pestilence",
        "Famine",
        "mail daemon",
        "djinni",
        "jellyfish",
        "piranha",
        "shark",
        "giant eel",
        "electric eel",
        "kraken",
        "newt",
        "gecko",
        "iguana",
        "baby crocodile",
        "lizard",
        "chameleon",
        "crocodile",
        "salamander",
        "long worm tail",
        "archeologist",
        "barbarian",
        "caveman",
        "cavewoman",
        "healer",
        "knight",
        "monk",
        "priest",
        "priestess",
        "ranger",
        "rogue",
        "samurai",
        "tourist",
        "valkyrie",
        "wizard",
        "Lord Carnarvon",
        "Pelias",
        "Shaman Karnov",
        "Earendil",
        "Elwing",
        "Hippocrates",
        "King Arthur",
        "Grand Master",
        "Arch Priest",
        "Orion",
        "Master of Thieves",
        "Lord Sato",
        "Twoflower",
        "Norn",
        "Neferet the Green",
        "Minion of Huhetotl",
        "Thoth Amon",
        "Chromatic Dragon",
        "Goblin King",
        "Cyclops",
        "Ixoth",
        "Master Kaen",
        "Nalzok",
        "Scorpius",
        "Master Assassin",
        "Ashikaga Takauji",
        "Lord Surtur",
        "Dark One",
        "student",
        "chieftain",
        "neanderthal",
        "High-elf",
        "attendant",
        "page",
        "abbot",
        "acolyte",
        "hunter",
        "thug",
        "ninja",
        "roshi",
        "guide",
        "warrior",
        "apprentice",
        "invisible monster"
    )
    private val tilesets = Uhluhtc.dataFolderPath.resolve("tilesets").toFile()
        .walk()
        .filter { it.isFile && (it.name.endsWith(".png") || it.name.endsWith(".bmp")) }
        .map {
            ImageIO.read(it)
        }
        .toSet()

    init{
        logger.info { "Loaded ${tilesets.size} tilesets" }
    }

    fun genImage(monName: String): List<InputStream> {
        val idx = tileMap366.indexOf(monName)
        val tiles = mutableListOf<InputStream>()
        tilesets.forEach {
            val tilesInLine = it.width / 32
            val y = idx / tilesInLine
            val x = idx - y * tilesInLine
            val posX = x * 32
            val posY = y * 32
            //logger.info { "idx:$idx     reX:$x X:$posX         reY:$y Y:$posY" }
            val tile = it.getSubimage(posX, posY, 32, 32)
            val os = ByteArrayOutputStream()
            ImageIO.write(tile, "png", os)
            tiles += ByteArrayInputStream(os.toByteArray())
        }
        return tiles
    }

    fun genSymImage(sym: String, color: String): InputStream {
        val image = BufferedImage(13, 22, BufferedImage.TYPE_INT_RGB)
        val g = image.createGraphics()
        val colors = mapOf(
            "black" to Color.decode("#000000"),
            "blue" to Color.decode("#0000AA"),
            "green" to Color.decode("#00AA00"),
            "cyan" to Color.decode("#00AAAA"),
            "red" to Color.decode("#AA0000"),
            "magenta" to Color.decode("#AA00AA"),
            "brown" to Color.decode("#AA5500"),
            "white" to Color.decode("#AAAAAA"),
            "gray" to Color.decode("#555555"),
            "brightblue" to Color.decode("#5555FF"),
            "brightgreen" to Color.decode("#55FF55"),
            "brightcyan" to Color.decode("#55FFFF"),
            "brightred" to Color.decode("#FF5555"),
            "brightmagenta" to Color.decode("#FF55FF"),
            "yellow" to Color.decode("#FFFF55"),
            "brightwhite" to Color.decode("#FFFFFF"),
        )
        //get default color set
        g.color = colors[color.lowercase()] ?: Color.white

        //font
        val font = Font("DejaVuSansMono", Font.PLAIN, 18)
        g.font = font
        val metrics = g.getFontMetrics(font)

        //center pos
        val positionX: Int = (image.width - metrics.stringWidth(sym)) / 2
        val positionY: Int = (image.height - metrics.height) / 2 + metrics.ascent

        g.drawString(sym, positionX, positionY)

        //output
        val os = ByteArrayOutputStream()
        ImageIO.write(image, "png", os)
        return ByteArrayInputStream(os.toByteArray())
    }

    fun genWikiImage(monName: String): InputStream {
        val doc = Jsoup.connect("https://nethackwiki.com/wiki/File:${monName.replace(" ", "_")}.png").get()
        val link = "https://nethackwiki.com" + doc.select("#file > a").attr("href")
        return Jsoup.connect(link).ignoreContentType(true).maxBodySize(3000000).ignoreHttpErrors(true).execute()
            .bodyStream()
    }
}