<p align="center"><img src="https://github.com/N1nt4nd0/Xenobyte/blob/master/logo.png" alt="Xenobyte logo"></p>

# Xenobyte

Client-side mod / “hack pack” for **Minecraft 1.7.10** with **Minecraft Forge**.  
Original project by **N1nt4nd0**; this tree may include community fixes and tooling updates.

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

**Output:** the main mod artifact is:

`build/libs/xenobyte-1.0.0.jar`

The build may also produce ProGuard mappings and a `final-*.jar` intermediate; the usual end result for Forge is the reobfuscated JAR name above. See `build.gradle` for the ProGuard + `reobf` chain.

**ForgeGradle / Mojang downloads:** upstream `ForgeGradle:1.2-SNAPSHOT` used dead Mojang S3 URLs. This repo uses the **GTNH ForgeGradle fork** (`1.2.11` via JitPack) so `downloadClient` works with current Mojang endpoints.

---

## Configuration

Runtime settings are stored as JSON:

- **Windows:** `%USERPROFILE%\xenobyte\config.cfg`  
  e.g. `C:\Users\<you>\xenobyte\config.cfg`

If something misbehaves, back up that file, delete it, and relaunch to reset module state.

---

## Native loader / CI

The `loader/` tree contains tooling (packer, `eloader`) used to build DLLs. **AppVeyor** (`appveyor.yml`) runs a full pipeline: Gradle build → packer → MSBuild → zipped artifacts. Local builds often only need the Gradle JAR for in-game testing.

---

## Video guide

- [YouTube — usage overview](https://youtu.be/nZAEb3mmXL4)

---

## Crash checklist

- Injector **OS / bitness** must match the game process and JVM.
- **Minecraft version** must match what the mod targets (1.7.10).
- Some **launchers** block injection.
- Use **Java 8+** for the game; use **JDK 8** to **compile** this project.

---

## Links (original author)

- [YouTube](https://www.youtube.com/channel/UClXGh0w1BiBEyxn7iFI4dsA)
- [Instagram](https://www.instagram.com/n1nt4nd0)
- [Telegram](https://t.me/N1nt4nd0)

---

## Thanks

Tenon4ik, Left4Dead, radioegor146, SongJ, and everyone who keeps old Forge tooling usable (e.g. GTNH ForgeGradle).

---

## Changelog

See [`CHANGELOG.md`](CHANGELOG.md) for notable updates (e.g. merged PRs and build fixes).
