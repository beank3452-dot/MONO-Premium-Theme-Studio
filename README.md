# MONO — Premium Theme Studio

Native Android starter project for the Samsung Galaxy S25 Ultra and other Android devices.

## Included
- Premium ivory/charcoal app interface.
- Bundled misty mountain wallpaper and one-tap wallpaper application.
- Native Android home-screen widget showing dynamic month, date and 24-hour digital clock.
- In-app instructions for applying monochrome icons with Samsung Good Lock / Theme Park.

## Important platform limitations
- A normal third-party Android app cannot silently replace Samsung One UI, the system lock-screen clock, or every installed app icon.
- The widget is a Home-screen widget, not a replacement for Samsung's lock-screen clock.
- Icon styling must be applied through a compatible launcher/theme mechanism. On Samsung, use Good Lock → Theme Park where supported by the installed One UI version.
- Android widgets are refreshed by the system. `updatePeriodMillis` is set to 30 minutes; clock refresh precision is therefore system-controlled and not guaranteed to update every minute.

## Build the APK
Requirements: Android Studio (or Android SDK + Gradle), JDK 17 or newer, Android SDK Platform 35, and Android Gradle Plugin 8.9.2.

1. Open this project folder in Android Studio.
2. Allow Gradle sync and install missing SDK components if prompted.
3. Select Build → Build Bundle(s) / APK(s) → Build APK(s).
4. The debug APK will be at `app/build/outputs/apk/debug/app-debug.apk`.

For a signed release APK, use Build → Generate Signed Bundle / APK.

## Package
Application ID: `com.umbrella.mono`
Version: `1.0.0`
Minimum Android: 9 (API 28)
Compile/target SDK: 35

## Build APK in the cloud using GitHub (phone-friendly)

This project includes `.github/workflows/android.yml` for GitHub Actions.

1. On your phone, create a **new public or private repository** on GitHub named `MONO-Premium-Theme-Studio` (do not add a README, license, or .gitignore during creation).
2. Upload the *contents* of this project folder to the repository root, including the hidden `.github` folder. If GitHub's mobile upload page does not show hidden folders, use GitHub's web interface in Chrome with **Desktop site** enabled, or upload the project from a computer.
3. Open the repository's **Actions** tab and enable workflows if GitHub asks.
4. Open **Build MONO Android APK** and tap **Run workflow** (or push to `main` to trigger it).
5. Wait for the workflow to finish successfully. Open the completed run and download the `MONO-debug-apk` artifact.
6. Extract the downloaded artifact ZIP on your phone. Tap `app-debug.apk` to install it. If Android asks, allow installation from that browser or file manager.

The cloud workflow creates a **debug APK** for testing. A distributable release APK should be signed with a private keystore; never commit that keystore or its passwords to the repository.
