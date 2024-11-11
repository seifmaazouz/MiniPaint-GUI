# MiniPaint App 🎨

**MiniPaint** is a lightweight, user-friendly painting application that enables users to create and edit basic shapes on a canvas. Built with a simple GUI, this app is ideal for quick sketches, simple design tasks, or as a beginner project to explore graphical user interface (GUI) programming.

---

## Features

- **Basic Shape Creation**: Draw rectangles, circles, lines, and polygons.
- **Shape Customization**: Adjust color, size, and position of each shape.
- **Colorize Shape**: Supports changin pen and fill colors.
- **Delete shape**: Quickly select shape from dropdown menu and delete it.
- **Position from Mouse**: Supports user-friendly input of shape position to be drawn by clicking on canvas.

---

## Architecture

- **ShapeDialog**: Interface to create and customize shapes. Acts as a temporary creator, holding shape data only during the creation process.
- **Shape**: Represents individual shapes with properties like size, color, and coordinates.
- **Engine**: Manages the created shapes, saves shape references, and handles canvas updates.

---
