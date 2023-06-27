# Compose101

Week 1 : Basic Compose layout
https://docs.google.com/spreadsheets/d/1UIRmTjAkZQFjY4ruwu8AS64XfN8AVgoGuWEZVqt6w4E/edit#gid=0

====================================================================================

Week 2 : Modifier and how Compose render the view
1. From data to UI: Compose phases - MAD Skills \
from 1:20
https://www.youtube.com/watch?v=0yK7KoruhSM&list=PLWz5rJ2EKKc94tpHND8pW8Qt8ZfT1a4cq&index=3
2. Constraints and modifier order - MAD Skills \
from 1:00
https://www.youtube.com/watch?v=OeC5jMV342A&list=PLWz5rJ2EKKc94tpHND8pW8Qt8ZfT1a4cq&index=4

Jetpack Compose ClipToPadding :\
https://stackoverflow.com/questions/66435811/jetpack-compose-cliptopadding

Jetpack Compose Clipchildren :\
https://stackoverflow.com/questions/68296439/jetpack-compose-row-clipping-children-when-width-increases \
```wrapContentSize(unbounded = true)```

====================================================================================

Week 3 : State, Lifecycle and Side-effects in Compose \
State :\
https://developer.android.com/jetpack/compose/state

Lifecycle :\
https://developer.android.com/jetpack/compose/lifecycle

Side-effects :\
https://developer.android.com/jetpack/compose/side-effects

```derivedStateOf```\
Use case key point : Every time you're converting state into a Boolean, consider derivedStateOf could help \
from 4:44 https://www.youtube.com/watch?v=EOQB8PTLkpY&list=PLWz5rJ2EKKc9Ty3Zl1hvMVUsXfkn93NRk&index=20 \
https://medium.com/androiddevelopers/jetpack-compose-when-should-i-use-derivedstateof-63ce7954c11b

====================================================================================

Week 4 : Recomposition
1. Composition scope :\
https://www.jetpackcompose.app/articles/donut-hole-skipping-in-jetpack-compose#recomposition \
Ripple is able to skip recomposition \
https://dev.to/zachklipp/scoped-recomposition-jetpack-compose-what-happens-when-state-changes-l78

2. Check performance by using ```compose_metrics``` \
   https://github.com/androidx/androidx/blob/androidx-main/compose/compiler/design/compiler-metrics.md 

   Enabling Metrics
   ```
   compileKotlin {
      freeCompilerArgs += listOf(
          "-P",
          "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=<directory>"
      )
      freeCompilerArgs += listOf(
          "-P",
          "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=<directory>"
      )
   }
   ```
   
   Run the build to check the report (remember to clean before gen the report) \
   ```
   ./gradlew clean
   ./gradlew assembleRelease -Pandroidx.enableComposeCompilerMetrics=true -Pandroidx.enableComposeCompilerReports=true
   ```
   https://proandroiddev.com/jetpack-compose-tutorial-improving-performance-in-dribbble-audio-app-b19848cf12e3

3. Stable \
   https://github.com/androidx/androidx/blob/androidx-main/compose/docs/compose-api-guidelines.md#stable-types \
   https://medium.com/androiddevelopers/jetpack-compose-stability-explained-79c10db270c8 \
   https://blog.csdn.net/vitaviva/article/details/126025275

   Immutable List \
   https://github.com/Kotlin/kotlinx.collections.immutable

4. Modifier recompose improvement \
   https://www.youtube.com/watch?v=SWBN0y0lFNY&list=PLWz5rJ2EKKc8fZY3smX9CPx9Y_O80ycAd&index=3

