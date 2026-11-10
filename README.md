# NeoBrut Player

An Android music player for people who want their local music library to feel like a physical object—not another polished, interchangeable streaming app.

NeoBrut Player is built around the Neo-Brutalist UI/UX concept: bold black-and-white layouts, high-contrast accent colors, hard borders, strong typography, visible controls, and deliberately unapologetic visual structure.

## First release

The first release focuses on being a reliable, fully offline player for music stored on your Android device.

Planned core capabilities include:

- Scanning and browsing local music files
- Artist, album, track, and library views
- Search across the local music library
- Play, pause, seek, previous, and next controls
- Recently played tracks
- Playlist support
- A clear, tactile now-playing experience
- No account, streaming service, or internet connection required for playback

## Design direction

The interface takes inspiration from Neo-Brutalism and physical music hardware: heavy frames, layered panels, oversized controls, raw data grids, and bright accent colors. The goal is to make the player expressive and easy to understand while keeping the music itself central.

## Visual references

The following mockups illustrate the intended visual direction for the first release:

### Home and library

![NeoBrut Player home screen](assets/neo-brut-home.png)

### Interface concepts

![NeoBrut Player interface mockups](assets/neo-brut-mockups.png)

## Project status

NeoBrut Player is currently in development. Features and visual details may change as the first release is built and tested.

## License

NeoBrut Player is free and open-source software licensed under the **GNU General Public License v3.0 or later**.

You are free to use, study, modify, and redistribute the project, including creating forks. Distributed modified versions must remain under the GPL and provide the corresponding source code under the license terms.

See the [LICENSE](LICENSE) file for the complete license text.

## Getting started

Open this folder in Android Studio and let Gradle sync. Install Android SDK Platform 37 when prompted, then run the `app` configuration on an emulator or Android device (Android 6.0 or newer).

The app is written in Kotlin and uses the Gradle wrapper. The checked-in Gradle daemon configuration requires JDK 25, which is bundled with the current Android Studio. Android Studio's bundled JDK can be selected under **Settings > Build, Execution, Deployment > Build Tools > Gradle**. For a terminal or VS Code, set `JAVA_HOME` to a compatible JDK installation and configure `ANDROID_HOME` to point to the Android SDK. Install the recommended VS Code extensions for Kotlin and Gradle support.

Build from the project root with `gradlew.bat assembleDebug` on Windows or `./gradlew assembleDebug` on macOS/Linux. The debug APK is generated at `app/build/outputs/apk/debug/app-debug.apk`. You can also use Android Studio to manage the SDK, emulator, and device deployment while editing in VS Code.

The welcome screen is an initial placeholder; music scanning and playback are not implemented yet.

## Lint

Run `gradlew.bat lint-fix` on Windows or `./gradlew lint-fix` on macOS/Linux to apply available automatic Android lint fixes. Review the resulting changes; lint cannot fix every issue automatically. Run `gradlew.bat lintDebug` or `./gradlew lintDebug` to check the debug build without applying fixes.
