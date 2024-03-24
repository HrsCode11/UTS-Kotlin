package id.ac.pnm.ti.utsmobilesatu

// data class id.ac.pnm.ti.utsmobilesatu.Club
data class Club(
    val name: String,
    val EPL: Int,
    val FA: Int,
    val EFL: Int,
    val UEL: Int,
    val UCL: Int
) {
    val totalTrophy: Int
        get() = EPL + FA + EFL + UEL + UCL
}

// extension function id.ac.pnm.ti.utsmobilesatu.recap
fun Club.recap(): String {
    return "$name: $totalTrophy"+"trophy"
}


