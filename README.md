# pshape-studio
> experiments with PShapes, beginContour(), quadraticVertex() textures, offScreenBuffers, nested graphics layers, feedback loops, etc.
____________



## Ref
* [Shiffman - Custom Shapes - p5.js Tutorial][1]
* [Rune's Programming Design Systems][2]
   * [Code examples for Rune's book on Github][5]
* [Centripetal Catmull–Rom spline][3]
* [A Brief History of Graphics][4]

-------

## Contours
From Rune's book:  
While we can draw most shapes with vertex(), quadraticVertex(), and bezierVertex(), these functions won't allow us to create shapes with holes. In P5.js, a hole is called a contour, and you can draw shapes with contours using the beginContour() and endContour() functions. In essence, the beginContour() function instructs P5 that you are starting a new shape that will be subtracted from your main shape. Like beginShape(), you use the vertex functions to draw your contour, and use endContour() to end the contour.







---------
[1]:https://www.youtube.com/watch?v=76fiD5DvzeQ
[2]:https://programmingdesignsystems.com/shape/custom-shapes/index.html#custom-shapes-pANLh0l
[3]:https://en.wikipedia.org/wiki/Centripetal_Catmull%E2%80%93Rom_spline
[4]:https://www.youtube.com/watch?v=QyjyWUrHsFc
[5]:https://github.com/runemadsen/programmingdesignsystems.com


