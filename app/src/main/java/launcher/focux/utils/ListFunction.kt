package launcher.focux.utils


fun List<AppModel>.sort() : Map<String, List<AppModel>> {
    val sorted : MutableMap<String, MutableList<AppModel>> = mutableMapOf()

    return this.filter { it.name.isNotEmpty() }
        .groupBy { it.name[0].uppercaseChar().toString() }
        .toSortedMap()
}