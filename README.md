# Smart Home

Smart Home is a project that simulates a smart home system. It includes various smart devices such as lights, thermostats, speakers, and cameras. The system allows for managing these devices through commands read from input files.

## Project Overview

Smart Home is developed using Java and provides a simulation of a smart home environment. The project includes different types of smart devices, each with specific functionalities and energy consumption patterns.

### Features

The project includes:
1. **Smart Devices**: Different types of smart devices such as lights, thermostats, speakers, and cameras.
2. **Device Management**: Ability to turn devices on/off, adjust settings, and perform specific actions (e.g., playing music, recording video).
3. **Energy Consumption**: Each device consumes energy for its operations, and devices cannot perform actions if their energy level is too low.
4. **Command Processing**: Commands to control devices are read from input files and processed sequentially.

## Technologies Used

- **Java**: The primary programming language used for developing the smart home system.

## Project Structure

The project structure includes several directories and files organized as follows:

- **`src/`**: Contains the source code for the project.
  - **`SmartHomeSystem.java`**: The main class that initializes and runs the smart home application.
  - **`SmartDevice.java`**: The abstract base class for all smart devices.
  - **`SmartLight.java`**: A subclass of SmartDevice representing a smart light.
  - **`SmartThermostat.java`**: A subclass of SmartDevice representing a smart thermostat.
  - **`SmartSpeaker.java`**: A subclass of SmartDevice representing a smart speaker.
  - **`SmartCamera.java`**: A subclass of SmartDevice representing a smart camera.
  - **`FileManager.java`**: A utility class for reading devices and commands from text files.

## Usage

### Prerequisites

To run the project, you need to have the following installed:
- **Java Development Kit (JDK)**: Ensure you have JDK installed on your system.

### Running the Project

1. Clone the repository:

    ```bash
    git clone https://github.com/barissolcay/smart-home.git
    cd smart-home/src
    ```

2. Compile the Java files:

    ```bash
    javac *.java
    ```

3. Run the Smart Home System with input files for devices and commands:

    ```bash
    java SmartHomeSystem devices.txt commands.txt
    ```

## Contributing

We welcome contributions to improve the Smart Home project. Feel free to open issues or submit pull requests if you have suggestions for improvements or find any bugs.

## License

MIT License

```markdown
MIT License

Copyright (c) 2025 Baris Solcay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
