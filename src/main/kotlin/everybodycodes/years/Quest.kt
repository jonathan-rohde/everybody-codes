package everybodycodes.years

import kotlin.io.path.Path
import kotlin.io.path.readText

interface Quest {

}


fun readInput(name: String, year: Int) = Path("src/main/resources/y${year}/$name.txt").readText().trim().lines()