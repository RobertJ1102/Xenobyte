# Changelog

All notable changes to this repository are summarized here.  
(Original Xenobyte history predates this file; entries focus on merged maintenance work.)

## [Unreleased]

- **Rebrand to PenguinMod:** `mod_id` `penguinmod`, display name **PenguinMod**, artifact `penguinmod-1.0.0.jar`, config dir `%USERPROFILE%/penguinmod/`.
- **English-only UI:** `LangProvider` no longer switches on `ru_RU`; all `lang.get("…", "…")` calls collapsed to a single English string; removed Russian from `Rand` splashes, `MsgSpammer` default line, disconnect message, and Credits UI button.
- **Click GUI** module list label: **ClickGUI** (was XenoGui).
- README refresh: build requirements, output paths, config location, ForgeGradle note.
- `.gitignore`: removed blanket `*.md` ignore so documentation can be tracked; loader JAR path updated for `penguinmod`.
- **Build:** **GTNH ForgeGradle** (`com.github.GTNewHorizons:ForgeGradle:1.2.11` via JitPack) so Gradle can download Minecraft `1.7.10` assets (Mojang’s old S3 URLs are dead for upstream `1.2-SNAPSHOT`).
- **AppVeyor:** artifact paths updated to `penguinmod` JAR names where applicable.
- **Removed ProGuard + native loader pipeline:** build is a normal Forge `jar` / `reobf` flow only; deleted `loader/` (packer, `eloader`, DLLs), ProGuard tasks, and unused `JavaInjector` (only existed for obfuscated injector class name). Install the JAR from `mods/` like any Forge mod.

## 2026-04-01 — Merged PR #1 (*Improve aura targeting and stabilize xray scanning*)

Merge commit: `ce20f7c` (branch `codex/audit-and-improve-minecraft-1.7.10-mod`).

### Packet handler

- Register the Netty pipeline handler under a **fixed name** (`xeno_packet_handler`) instead of a random one, and **remove** any previous handler before adding. Avoids duplicate handlers on reconnect / handler re-init.

### XRay

- **No overlapping scans:** `updateInProgress` gate so a new scan does not start while one is running.
- **Vertical range:** scan **player Y ± height** (clamped 0–255) instead of always from Y=0 upward (matches the height slider semantics better).
- **Tracer / line origin:** read viewer/player position in **`RenderWorldLast`** once per frame instead of inside every block lambda.
- **Volatile** `blocks` list reference for safer handoff between scan thread and render thread (still not ideal to read the world off-thread, but behavior is more predictable).

### XenAura (combat)

- **`maxTargets`** (1–10, default 1): cap how many entities are attacked per tick.
- **Nearest first:** sort candidates by distance before applying the limit.
- **i-frames:** skip entities with `hurtResistantTime > 0`.
- **Critical hits:** only send the crit packet sequence if the player **`canEntityBeSeen`** by the target (can reduce crits through walls when other filters allow hits).

### Config

- **`char` fields:** parsing no longer uses `Charset.forName` on the stored value (which was incorrect for a single character). Unused in stock modules but fixes edge-case configs.

### NetUtils

- **`setDoOutput(false)`** for simple GET-style fetches.
- **UTF-8** `InputStreamReader`, try-with-resources, empty string on failure.

---

Earlier history (e.g. ELoader, exploits, refactors) remains in `git log`.
