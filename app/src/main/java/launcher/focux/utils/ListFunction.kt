package launcher.focux.utils

import launcher.focux.AppModel
import java.util.SortedMap


fun List<AppModel>.sort() : SortedMap<String, List<AppModel>> {
    val sorted : MutableMap<String, MutableList<AppModel>> = mutableMapOf()

    return this.filter { it.name.isNotEmpty() }
        .groupBy { it.name[0].uppercaseChar().toString() }
        .toSortedMap()
}