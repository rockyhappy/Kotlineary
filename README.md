# Kotlineary

RecipeApp is a Kotlin-based Android application designed to showcase popular recipes and allow users to search for recipes, view detailed information, and mark favorites. The app follows Clean Architecture principles and MVVM (Model-View-ViewModel) architecture pattern. It utilizes Dagger Hilt for dependency injection, Room DB for local data storage, and Jetpack Compose for modern UI design.

## Features

- **Home Screen**: Displays a list of popular recipes fetched from the *Get Random Recipes* API and all recipes fetched from the *Search Recipes* API.
- **Recipe Details**: Users can view complete information about a selected recipe, including ingredients, instructions, nutrients, and similar recipes.
- **Search Recipes**: Users can search for recipes and mark them as favorites locally.
- **Favorites**: Favorite recipes are cached locally and can be filtered or sorted.
- **Bottom Sheet Navigation**: When a searched recipe is opened in a bottom sheet, users can click further to get more details (ingredients, full recipe, similar recipes). Each detail layout comes with a bottom-to-top animation and is kept in a stack. Users can swipe down to navigate back to previous information.
- **Ads**: An ad is displayed in between every five recipes in the list.
- **Modular Networking**: Networking operations are handled in a separate module.

## Architecture

The app is built using Clean Architecture principles, which ensure a clear separation of concerns and scalability. The main layers are:

- **Domain Layer**: Contains use cases and repository interfaces.
- **Data Layer**: Contains repository implementations and data sources (both remote and local).
- **Presentation Layer**: Contains ViewModels and UI components.

## Technologies Used

- **Kotlin**: Programming language
- **Jetpack Compose**: Modern toolkit for building native UI
- **Dagger Hilt**: Dependency Injection
- **Room DB**: Local database storage
- **Retrofit**: HTTP client for API calls
- **Coil**: Image loading library
- **Coroutines**: Asynchronous programming
- **Navigation Component**: Handling navigation within the app

## Getting Started

### Prerequisites

- Android Studio Arctic Fox (or later)
- Kotlin 1.5 (or later)

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-repo/recipeapp.git
    cd recipeapp
    ```

2. Open the project in Android Studio.

3. Sync the project with Gradle files.

4. Create a `local.properties` file in the root directory of the project and add your API keys:
    ```properties
    api_key="YOUR_API_KEY"
    ```

5. Build and run the project on an emulator or physical device.


## Modules

- **data**: Contains the data handling logic including local (Room) and remote (Retrofit) data sources.
- **domain**: Contains the business logic including use cases and repository interfaces.
- **presentation**: Contains UI-related classes including ViewModels and Jetpack Compose UI components.
- **di**: Contains Dagger Hilt modules for dependency injection.

## APK
[Apk-release](https://drive.google.com/file/d/1lvVMXCihXlCRE5n7hxXcAPg2HTFYGrek/view?usp=sharing)

## Screenshots

<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/802da320-b173-4220-99a7-50ae513b267e" alt="News App Screenshot 1" width="150" >
<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/8581716a-9a83-4921-b59a-7b128be2a080" alt="News App Screenshot 1" width="150" >
<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/eb1af86a-96d7-42c2-a34b-d659be16f3d6" alt="News App Screenshot 1" width="150" >
<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/c1626c9a-1571-4349-87b7-a3ab31f781e8" alt="News App Screenshot 1" width="150" >
<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/ffc02186-5720-490b-9e50-c6b0240b718c" alt="News App Screenshot 1" width="150" >
<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/1fe6d191-36ea-43fb-8971-4e5030dcaf2c" alt="News App Screenshot 1" width="150" >
<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/83478117-b7d2-4c39-9c31-cdec155456ce" alt="News App Screenshot 1" width="150" >
<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/c742ca31-54c9-4f3b-ba6c-599d3315cc4d" alt="News App Screenshot 1" width="150" >
<img src="https://github.com/rockyhappy/Kotlineary/assets/115190222/f74052a5-b807-4cc0-bf79-e3dcc735e475" alt="News App Screenshot 1" width="150" >

## Video


https://github.com/rockyhappy/Kotlineary/assets/115190222/6878b8cf-aa97-4b5e-91a8-d4eae765d88d


## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Dagger Hilt](https://dagger.dev/hilt/)
- [Room DB](https://developer.android.com/training/data-storage/room)
- [Retrofit](https://square.github.io/retrofit/)
- [Coil](https://coil-kt.github.io/coil/)

