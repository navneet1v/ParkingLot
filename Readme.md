Parking Lot

This is a Parking Lot Command Line Tool. It has some basic functionalities like:
1. <code>create_parking_lot \<number of parking slots to be created\> </code>
2. <code>park <car registration number> \<car color\> </code>
3. <code>leave \<parking slot number\> </code>
4. <code>status </code>
5. <code>registration_numbers_for_cars_with_color \<color\> </code>
6. <code>slot_numbers_for_cars_with_color \<color\> </code>
7. <code>slot_number_for_registration_number \<car registration number\> </code>

The code is very naive. There are some opportunities in the overall structure of the code that can be improved:
1. There is a Car class present. There should be a Vehicle Class and Car class should extend the Vehicle class.
2. The color of the car is taken as string, it should be an Enum.
