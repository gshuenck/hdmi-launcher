# 📺 HDMI Launcher

**One-tap app to open the HDMI input on your projector / Fire TV.**

---

## 🇧🇷 Português (Brasil)

**HDMI Launcher** é um app Android minimalista, desenvolvido para quem usa um projector (Amazon Fire TV / Android TV) e não quer ficar enviando comandos ADB toda hora.

### Como funciona

O app, ao ser aberto, dispara automaticamente o mesmo intento que o app oficial Awlivetv:

```bash
adb shell am start -n com.softwinner.awlivetv/.MainActivity
```

Internamente, o `MainActivity` do HDMI Launcher faz exatamente isso:

```java
Intent intent = new Intent(Intent.ACTION_MAIN);
intent.setComponent(
    new ComponentName("com.softwinner.awlivetv", "com.softwinner.awlivetv.MainActivity")
);
startActivity(intent);
```

### Instalação

1. Instale o APK no projector/TV:

```bash
adb install hdmi-launcher.apk
```

2. Abra o app **HDMI** no launcher do dispositivo
3. Pronto — o HDMI é aberto / o seletor de entrada é exibido

### Como abrir o HDMI

- **Antes:** `adb shell am start -n com.softwinner.awlivetv/.MainActivity`
- **Agora:** toque no ícone do app **HDMI**

---

## 🇬🇧 English

**HDMI Launcher** is a minimal Android app for Fire TV / Android TV projectors that lets you open the HDMI input with a single tap, instead of typing an ADB command every time.

### How it works

When opened, the app fires the same intent used by the Awlivetv app:

```bash
adb shell am start -n com.softwinner.awlivetv/.MainActivity
```

Internally, the `MainActivity` does exactly this:

```java
Intent intent = new Intent(Intent.ACTION_MAIN);
intent.setComponent(
    new ComponentName("com.softwinner.awlivetv", "com.softwinner.awlivetv.MainActivity")
);
startActivity(intent);
```

### Installation

1. Install the APK on the projector / Fire TV:

```bash
adb install hdmi-launcher.apk
```

2. Open the **HDMI** app from the device launcher
3. That's it — the HDMI input is opened / the input selector is shown

### Usage

- **Before:** `adb shell am start -n com.softwinner.awlivetv/.MainActivity`
- **Now:** tap the **HDMI** app icon

---

## 📱 Built with

- Android SDK (compileSdk 37, minSdk 21, targetSdk 31)
- Kotlin-free / plain Android framework `Activity`
- `aapt2`, `javac`, `d8`, `zipalign` and `apksigner` from the Android build-tools

## 🔧 Rebuild

```bash
aapt2 compile --dir res -o compiled.zip
aapt2 link -I $ANDROID_HOME/platforms/android-37.0/android.jar --manifest AndroidManifest.xml --java gen -o base.apk compiled.zip
javac -source 8 -target 8 -classpath $ANDROID_HOME/platforms/android-37.0/android.jar:gen -d classes src/com/shuenck/hdmi/MainActivity.java gen/com/shuenck/hdmi/R.java
d8 --lib $ANDROID_HOME/platforms/android-37.0/android.jar --output /tmp/dex classes.jar
# add classes.dex to base.apk, then zipalign + apksigner sign
```
