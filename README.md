<p align="center"><b>PenguinMod</b></p>

# PenguinMod

Client-side mod for **Minecraft 1.7.10** with **Minecraft Forge**.  
Forked from the Xenobyte lineage; English UI, renamed artifact, and maintenance fixes.

[![Build status](https://ci.appveyor.com/api/projects/status/qjnhgxe3cmcy0y6y/branch/master?svg=true)](https://ci.appveyor.com/project/N1nt4nd0/xenobyte/branch/master)

---

## Requirements

| Requirement | Notes |
|-------------|--------|
| **Minecraft** | `1.7.10` |
| **Forge** | Matches `build.gradle` (e.g. `10.13.4.1614-1.7.10`) |
| **JDK** | **Java 8 JDK** (not a JRE). Gradle and `javac` need `tools.jar`. |
| **Gradle** | Use the included wrapper (`gradlew` / `gradlew.bat`). Version is pinned in `gradle/wrapper/`. |

Do **not** use Java 21+ to **run** this Gradle version: the wrapper is too old. Use **JDK 8** for `./gradlew`.

---

## Building

From the repository root:

```bat
gradlew.bat build
```

On Linux/macOS:

```bash
chmod +x gradlew
./gradlew build
```

Set `JAVA_HOME` to your **JDK 8** install if the wrong Java is picked up:

```powershell
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-8.x.x-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%
```

**Output:** the mod JAR (Forge reobfuscated) is:

`build/libs/penguinmod-1.0.0.jar`

Drop it into your `mods` folder like any other Forge mod.

**ForgeGradle / Mojang downloads:** upstream `ForgeGradle:1.2-SNAPSHOT` used dead Mojang S3 URLs. This repo uses the **GTNH ForgeGradle fork** (`1.2.11` via JitPack) so `downloadClient` works with current Mojang endpoints.

---

## Configuration

Runtime settings are stored as JSON:

- **Windows:** `%USERPROFILE%\penguinmod\config.cfg`  
  e.g. `C:\Users\<you>\penguinmod\config.cfg`

If something misbehaves, back up that file, delete it, and relaunch to reset module state.  
(Older Xenobyte configs lived under `%USERPROFILE%\xenobyte\` — that path is no longer used after the rename.)

---

## CI

**AppVeyor** (`appveyor.yml`) runs `gradlew.bat build` and publishes `build/libs/penguinmod-1.0.0.jar`.

---

## Crash checklist

- **Minecraft version** must match what the mod targets (1.7.10).
- Use **Java 8** for the game; use **JDK 8** to **compile** this project.

---

## Changelog

See [`CHANGELOG.md`](CHANGELOG.md).
