object Versions
{
    const val nav_compose = "2.7.7"
    const val hilt_navigation_compose = "1.1.0"
    const val coil_compose = "2.5.0"
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.0"
    const val lifecycle_viewmodel_compose = "2.7.0"
    const val kotlinx_coroutines_android = "1.7.3"
    const val lifecycle_runtime_compose = "2.7.0"
    const val room_version = "2.6.1"
    const val kotlin_compiler_extension_version = "1.5.1"
    const val dagger_hilt_android = "2.50"
    const val google_devtools_ksp = "1.9.0-1.0.13"
    const val compose_version = "1.5.1"
    const val compose_activity_version = "1.7.2"
    const val compose_ui = "1.0.5"
    const val compose_ui_graphics = "1.0.5"
    const val compose_ui_tooling_preview = "1.0.5"
    const val compose_material3 = "1.0.0-alpha05"
    const val junit = "4.13.2"
    const val androidx_junit = "1.1.3"
    const val androidx_espresso_core = "3.4.0"
    const val androidx_ui_test_junit4 = "1.1.3"
    const val androidx_ui_tooling = "1.0.0"
    const val androidx_ui_test_manifest = "1.0.0"
    const val hilt_compiler = "2.50"
}
object Deps
{
    const val nav_compose="androidx.navigation:navigation-compose:${Versions.nav_compose}"
    const val hilt_navigation_compose="androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation_compose}"
    const val coil_compose="io.coil-kt:coil-compose:${Versions.coil_compose}"
    const val retrofit="com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okhttp="com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val lifecycle_viewmodel_compose="androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle_viewmodel_compose}"
    const val kotlinx_coroutines_android="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines_android}"
    const val lifecycle_runtime_compose="androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycle_runtime_compose}"
    const val dagger_hilt_android="com.google.dagger:hilt-android:${Versions.dagger_hilt_android}"
    const val room_runtime="androidx.room:room-runtime:${Versions.room_version}"
    const val hilt_compiler="com.google.dagger:hilt-compiler:${Versions.hilt_compiler}"
}

object AndroidTestImplemetation{
    const val dagger_hilt_android_testing="com.google.dagger:hilt-android-testing:${Versions.dagger_hilt_android}"
}

object TestImplementation{
    const val dagger_hilt_testing="com.google.dagger:hilt-android-testing:${Versions.dagger_hilt_android}"
}