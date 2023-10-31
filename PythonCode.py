class CircleComp:
    def __init__(self, radius):
        self.radius = radius
        self.diameter = self.radius * 2.0
        self.circumference = 2.0 * 3.14159 * self.radius
        self.area = 3.14159 * self.radius * self.radius

    def print_diameter(self):
        print("Diameter:", self.diameter)

    def print_area(self):
        print("Area:", self.area)

# Read radius from the user
radius = float(input("Enter the radius of the circle: "))

# Create an instance of CircleComp
circle = CircleComp(radius)

# Print diameter and area
circle.print_diameter()
circle.print_area()
