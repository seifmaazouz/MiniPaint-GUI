# MiniPaint App 🎨

**MiniPaint** is a lightweight, user-friendly painting application built in Java using the Swing graphics library. It supports creating, customizing, and managing shapes on a canvas. This tool is designed for beginners exploring GUI programming and Object-Oriented concepts.

---

## Features

1. **Shape Creation and Management**
   - Create basic shapes: rectangles, circles, squares, and lines.
   - Assign unique names to shapes (e.g., `circle01`, `rectangle03`).
   - Organize and manage shapes using a drop-down menu for easy selection.

2. **Shape Customization**
   - Adjust properties such as position, size, and color.
   - Resize and move shapes via a simple interface.
   - Customize pen and fill colors for a polished look.

3. **Interactive GUI**
   - Utilize a graphical interface for selecting and editing shapes.
   - Input properties (position, radius, etc.) via dialog boxes.
   - Position shapes easily by clicking on the canvas.


4. **File Operations**
   - Save and load shapes to/from a file for persistence.

5. **Deletion, Undo and Redo**
   - Delete selected shapes from the drop-down menu.
   - Include optional undo and redo features for accidental edits.

---

## Architecture

1. **ShapeDialog**
   - Handles temporary input for creating and customizing shapes.

2. **Shape**
   - Represents a geometric object with attributes like type, size, and coordinates.

3. **Engine**
   - Manages all shape instances, updates the canvas, and facilitates file operations.

4. **GUI Interface**
   - Developed using Java Swing for buttons, menus, and dialog boxes.

---

### UML Diagram

The app design utilizes inheritance and polymorphism, ensuring scalability and clean code. The UML diagram illustrates relationships between:
- Base Class: `Shape`
- Derived Classes: `Circle`, `Rectangle`, `Square`, `LineSegment`
- Additional utilities for managing events and file I/O.

---
