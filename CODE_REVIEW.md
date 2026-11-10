# Code Review: pshape-studio

> Revised: 2026-11-10 (replaces the 2026-02-04 review)
> Reviewer: Claude Code

## Why this was revised

The first review credited three "expert patterns" (GROUP PShape particle
batching, textured sprite quads, `setVertex()` wiggling) to the repo owner.
Those come from Processing's bundled examples by Daniel Shiffman, which live in
`examples/`. It also invented a quoted "realization" the author never wrote.
This version only assesses the author's own work in `previous_on/`.

## What's in the repo

| Folder | Contents | Author |
|---|---|---|
| `examples/` | 17 sketches: Processing's stock PShape/shape examples | Shiffman, Ira Greenberg, Processing |
| `previous_on/a_*`, `b_*` | 2015 practice sketches | jstephens |
| `previous_on/s_1805*`–`s_1806*` | 2018 "kidsPace" R&D: feedback loops, PGraphics, PShape | jstephens |

## Intent

A live visual instrument: feedback loops driven by mouse and keyboard, with
timestamped frame recording and snapshots built for capturing performances.

## Skills assessment

| Area | Level |
|---|---|
| Visual intuition / composition | Strong |
| Processing graphics (PGraphics, blend modes, transforms) | Intermediate |
| Math (trig, PVector) | Basic–intermediate |
| GPU / rendering model | Intuitive, not yet precise |
| Code structure and reuse | Beginner |
| Git / repo hygiene | Beginner |

## Strengths

- **Daily iteration.** Dated variants (`s_180603_01` → `_02` → `_03`) — a painter's study method.
- **Homemade tooling.** `recordFrames.pde` makes timestamped directories so restarted recordings never overwrite; `snapScreen()` hides the cursor before saving.
- **Readable function names.** `drawTwirlingBaton()`, `checkAndSetMouseLocation()` — `draw()` reads like a recipe.
- **Refactoring in flight.** Inline mouse logic became its own function between runner versions.
- **The "infinity" sketches** discover recursive zoom by drawing a buffer into itself.

## Problems

1. **`myPolygon` was broken (fixed in this PR).** An `int` loop counter with `a += theta` truncated every step: 3 sides gave 4 vertices, and 7+ sides looped forever.
2. **Self-sampling buffer.** `pg_1.image(pg_1, …)` reads and writes the same framebuffer — undefined in OpenGL. Use two buffers and swap them each frame (ping-pong).
3. **Stray matrix calls / unused buffer.** Main-canvas `pushMatrix()` inside a `pg_1` block; a `3×`-size `bg` buffer that's never used.
4. **Per-frame waste.** `drawFeedbackLayer()` allocates a full-screen image and copies pixels by hand into two identical images every frame; `get()` does it in one call.
5. **Copy-paste library.** `utilities`, `keyEVENTS`, `recordFrames`, `screenSnaps`, `instructions` are byte-identical in 5 folders and carry stubs from another project (`'r'` is bound twice).
6. **Dead code and labels.** Unused `Particle` class, large commented blocks, 2018 files headed "2016_06", "opcacity" typo.
7. **Repo hygiene (fixed in this PR).** `.gitignore` patterns like `.tif` matched nothing; compiled `build-tmp/` files were committed.

## Next steps

1. Separate your work from the stock examples (delete or move to `reference/` with credit).
2. One shared toolkit for record/snap/keys instead of five copies.
3. Rebuild the infinity effect with ping-pong buffers and expose zoom/rotate/fade as parameters.
4. Pick three best sketches and put GIFs at the top of the README.

## Alternative paths

- **GLSL fragment shaders** — the natural home for feedback; GPU-fast and high-res.
- **p5.js** — shareable by link, matches the Rune Madsen material in the README.
- **TouchDesigner** — if the goal is live performance (Feedback TOP, MIDI, audio).
- **Stampfli-style kaleidoscope shader + your feedback loop** — a direction that's distinctly yours.
