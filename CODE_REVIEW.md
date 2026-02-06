# Code Review: pshape-studio

> Review conducted: 2026-02-04
> Reviewer: Claude (Opus 4.5)

---

## Executive Summary

**pshape-studio** is a Processing-based creative coding laboratory exploring PShapes, feedback loops, particle systems, and generative graphics. The codebase spans 2015-2018, containing 78 PDE files across 37 sketches—17 polished examples and 20 experimental archives. It demonstrates a developer progressing from fundamentals toward intermediate-advanced creative coding proficiency.

---

## Coding Style

### Signature Characteristics

| Trait | Example | Observation |
|-------|---------|-------------|
| **Header Documentation** | `/*jstephens - 2018_05...*/` | Consistent authorship and dating |
| **TODO-Driven Development** | `TODO: - [] map baton rotation to location.x` | Checkbox-style task tracking in code |
| **Exploratory Comments** | `//image(baseLayer, mouse.y-(1/(mouse.y+1))...` | Heavy commented alternatives preserved |
| **Descriptive Functions** | `drawTwirlingBaton()`, `drawFeedbackLayer()` | Verb-noun naming convention |
| **Utility Segregation** | `keyEVENTS.pde`, `utilities.pde`, `recordFrames.pde` | Modular file organization |
| **Visual Separation** | `//////////////////////` comment blocks | ASCII art section headers |

### Formatting Tendencies

```processing
// Mixed styles observed:
y+=speed;              // compact operators (sometimes)
y += speed;            // spaced operators (other times)
pg_1, ps_1             // underscore_numbered suffixes
mouseIsEngaged         // camelCase booleans
SNAP_FOLDER_PATH       // SCREAMING_SNAKE for constants
```

**Style Summary:** The code reads like a **lab notebook**—functional, annotated, and preserving the experimental journey. Comments explain *intent* more than mechanics. File headers serve as project documentation.

---

## Skill Assessment

### Level: **Intermediate Creative Coder** (moving toward Advanced)

| Domain | Level | Evidence |
|--------|-------|----------|
| Processing API | Advanced | Deep PShape mastery, PGraphics buffers, blend modes |
| Graphics Math | Solid | Polar coordinates, matrix transforms, Perlin noise |
| OOP | Intermediate | Good encapsulation, but limited abstraction |
| Performance | Good | Understands GROUP PShapes, batch rendering |
| Code Organization | Intermediate | Modular utilities, but globals dominate |
| Software Engineering | Developing | Limited error handling, no tests |

### Competencies Demonstrated

1. **Graphics Pipeline Understanding** - Correct `beginDraw()`/`endDraw()` sequencing, pixel buffer manipulation
2. **Vector Mathematics** - Comfortable with `PVector`, `fromAngle()`, trigonometric transformations
3. **Animation Principles** - Velocity, gravity, oscillation, noise-based organic motion
4. **Interactive Design** - Keyboard/mouse input handling with state management
5. **Performance Awareness** - Recognizes why GROUP PShapes render 10,000 particles efficiently

---

## Expert Patterns (Strengths)

### 1. PShape Optimization for Batch Rendering
```processing
// ParticleSystem.pde:12-21
particleShape = createShape(GROUP);
for (int i = 0; i < n; i++) {
  Particle p = new Particle();
  particles.add(p);
  particleShape.addChild(p.getShape());  // Single draw call for 10,000 particles
}
```
**Why it's expert:** Most beginners would call `shape()` 10,000 times per frame. This code understands GPU batching.

### 2. Texture-Mapped Quads with UV Coordinates
```processing
// Particle.pde:23-30
part.texture(sprite);
part.normal(0, 0, 1);
part.vertex(-partSize/2, -partSize/2, 0, 0);
part.vertex(+partSize/2, -partSize/2, sprite.width, 0);
```
**Why it's expert:** Correct UV mapping with proper normal specification shows understanding of 3D graphics fundamentals.

### 3. Vertex Animation via setVertex()
```processing
// Wiggler.pde:44-52
for (int i = 0; i < s.getVertexCount(); i++) {
  PVector pos = original.get(i);
  float a = TWO_PI*noise(xoff,yoff);
  PVector r = PVector.fromAngle(a);
  r.mult(4);
  r.add(pos);
  s.setVertex(i, r.x, r.y);  // Direct vertex manipulation
}
```
**Why it's expert:** Most developers redraw shapes; this modifies vertices in-place for efficiency.

### 4. Feedback Loop Architecture
```processing
// s_180604_01_pshape_green_infinity_pde.pde:86-99
pg_1.image(pg_1, -20, -20, width*2.8, height*2.8);  // Self-reference
pg_1.shape(ps_1, -20, -20);
pg_1.blendMode(BLEND);
pg_1.image(pg_1, 0, 0, width*1.2, height*1.2);     // Layered feedback
```
**Why it's expert:** Self-referential buffer drawing with blend modes demonstrates deep graphics knowledge.

### 5. Reusable Utility Library Pattern
```processing
// recordFrames.pde:13-31
String frameAsString() {
  return version + "/" + nf(year(),4) + nf(month(),2) + nf(day(),2) + "-" +
         nf(hour(),2) + nf(minute(),2) + "/" + ...
}
```
**Why it's expert:** Production-quality file organization with timestamped directories.

---

## Novice Patterns (Areas to Evolve)

### 1. Magic Numbers
```processing
// Star.pde:12-13
x = random(100, width-100);  // Why 100?
speed = random(0.5, 3);      // Why these bounds?
```
**Recommendation:** Extract to named constants.

### 2. Verbose Boolean Returns
```processing
// Particle.pde:61-68
boolean isDead() {
  if (center.x > width || ...) {
    return true;
  } else {
    return false;  // Unnecessary
  }
}
```
**Recommendation:** Return the condition directly: `return center.x > width || ...;`

### 3. Heavy Global State Reliance
```processing
// s_180530_01_pshape.pde - 9 global variables
boolean saveFrameIsOn, recordIsOn, cursorIsOn;
String SNAP_FOLDER_PATH, FRAME_FOLDER_PATH, directoryStartTime, project, version;
PGraphics pg_1;
PShape ps_1;
```

### 4. Commented-Out Code as Version Control
Multiple files contain 10-20 lines of commented alternatives. Git handles history better.

---

## The Narrative from Comments

The comments tell the story of **a visual artist learning to code**, not a programmer learning graphics.

### The Experimenter's Journal
```processing
/*jstephens - 2016_06
 feedback_runner
 navigate ellipse through a feedback scene
```
Dated entries like a lab notebook. Projects have names ("kidsPace", "feedback_runner") suggesting personal connection.

### The Incomplete Todo Lists
```processing
TODO:
- [] map baton rotation to location.x
- [] make arrows the controllers
- [] perlin noise the width, height, rotation
```
These same TODOs appear in **4 different files** spanning 2016-2018—dreams deferred but not forgotten.

### The Reference Collector
The README contains 20 curated links to Shiffman tutorials, Rune's Design Systems, Peter Stampfli's kaleidoscopes, and academic papers. This reveals **deep curiosity** and aspiration toward mathematical art.

### The Archaeologist
The `previous_on/` directory preserves every experiment. Version names (`s_180530_01`, `s_180604_02`) show **daily iteration**—sometimes multiple experiments per day.

---

## Key Discovery: Nested Feedback Loops & The Triangle

### The Insight Location

Found in `previous_on/s_180604_01_pshape_green_infinity_pde/utilities.pde:42-50`:

```processing
//////////////////////////////////////////////////
//  MAKE PIXELS CLEAR FOR PGRAPHIC  =  'TAB'
void makePixelsClearAgain() {
    //background(0);        // <-- MAIN CANVAS COMMENTED OUT
    pg_1.beginDraw();
    pg_1.clear();           // <-- ONLY CLEARS PGRAPHIC TO TRANSPARENT
    pg_1.endDraw();
}
//  END: MAKE PIXELS CLEAR
//////////////////////////////////////////////////
```

### The Discovery: `clear()` vs `background()`

| Method | Effect | Alpha |
|--------|--------|-------|
| `background(0)` | Fills with opaque black | 255 |
| `clear()` | Fills with transparent | 0 |

### Why the Triangle Matters

The 3-vertex triangle (`ps_1`) is the **simplest closed polygon**—the minimal shape to demonstrate feedback behavior:

```processing
// The triangle definition (s_180530_01 through s_180605_01)
ps_1.vertex(50, 10);
ps_1.vertex(10, 200);
ps_1.vertex(110, 200);
ps_1.endShape(CLOSE);
```

### The "Untethered" Feedback Loop Pattern

1. **Main canvas:** `background()` is **commented out** in `draw()`
2. **PGraphics buffer:** Uses `clear()` (transparent) not `background()` (opaque)
3. **Triangle drawn to buffer:** `pg_1.shape(ps_1, x, y)`
4. **Buffer self-references:** `pg_1.image(pg_1, ...)` creates infinity effect
5. **Result:** Triangle feedback accumulates on main canvas without being overwritten

### The Evolution

| Date | File | Vertices | Background | Buffer Size |
|------|------|----------|------------|-------------|
| 2018-05-30 | `s_180530_01_pshape` | 3 (triangle) | `background(0)` active | `width, height` |
| 2018-06-02 | `s_180602_01_pshape_opcacity` | 3 (triangle) | `//background(0)` commented | `width*3, height*3` |
| 2018-06-04 | `s_180604_01_green_infinity` | 4 (quad) | `//background(0)` commented | `width*3, height*3` |

### The Realization

> **"The main graphics context has its own refresh cycle. If I don't call `background()`, the main canvas becomes a persistence layer. Combined with PGraphics `clear()`, I can control feedback at TWO levels independently—the buffer clears to transparent but the canvas accumulates. The triangle floating on transparency compounds visually without being overwritten."**

The function name `makePixelsClearAgain()` encodes this discovery—"clear" means something fundamentally different than "background" for nested graphics contexts.

---

## Recommendations

### Immediate (Low Effort, High Impact)
1. Add `Constants.pde` with named magic numbers
2. Clean commented code—trust Git history
3. Fix variable naming inconsistencies

### Short-Term (Code Quality)
4. Create abstract `AnimatedShape` base class for shared behavior
5. Standardize on camelCase for all variables
6. Add null checks for loaded resources

### Long-Term (Architecture)
7. Implement configuration file for paths
8. Document the experimental archive with lessons learned
9. Consider extracting the feedback loop pattern into a reusable class

---

## Final Assessment

This codebase is exactly what it should be—**a creative playground**. The "weaknesses" are acceptable in R&D code. As a personal learning laboratory, the code accomplishes its goal: **enabling rapid visual experimentation**.

The developer demonstrates strong graphics intuition, willingness to experiment prolifically, good modular instincts, and performance awareness. Growth edges include software engineering discipline (DRY, SOLID), code hygiene, and abstraction patterns.
