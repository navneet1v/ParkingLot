Parking Lot

This is a Parking Lot Command Line Tool. It has some basic functionalities like:
1. create_parking_lot <number of parking slots to be created>
2. park <car registration number> <car color>
3. leave <parking slot number>
4. status
5. registration_numbers_for_cars_with_color <color>
6. slot_numbers_for_cars_with_color <color>
7. slot_number_for_registration_number <car registration number>

The code is very naive. There are some opportunities in the overall structure of the code that can be improved:
1. There is a Car class present. There should be a Vehicle Class and Car class should extend the Vehicle class.
2. The color of the car is taken as string, it should be an Enum.