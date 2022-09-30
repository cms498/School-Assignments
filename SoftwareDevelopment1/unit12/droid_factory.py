"""
This program simulates assembling droids using queues and stacks
Author: Chris Shepard
"""
import array_queue
import droids
import node_stack

def unload_shipment(filename, belt):
    """
    Simulates unload all of the parts from a given file onto the conveyor_belt
    """
    with open(filename) as file:
        for part in file:
            part = part.strip()
            if part != "":
                belt.enqueue(part)
    return belt

def install_part(droid, my_belt, their_belt):
    """
    Installs a part on the droid, if not needed the part is placed on their_belt
    """
    part = my_belt.dequeue()
    if droid.needs_part(part):
        droid.install_part(part)
    else:
        their_belt.enqueue(part)

def pack(container, droid):
    """
    Helper functions for packing droids into containers
    """
    container.push(droid)
    return container.size() < 5

def assemble_droids(worker_belt, coworker_belt):
    """
    assembles one droid, extra parts are placed on the coworker_belt
    """
    cargo_ship = node_stack.Stack()
    container = node_stack.Stack()
    protocol_droid = droids.Droid("Protocol")
    astromech_droid = droids.Droid("Astromech")
    while worker_belt.size() > 0 or coworker_belt.size() > 0:
        if protocol_droid.is_complete():
            if pack(container, protocol_droid) == False:
                cargo_ship.push(container)
                container = node_stack.Stack()
            protocol_droid = droids.Droid("Protocol")
        elif astromech_droid.is_complete():
            if pack(container, astromech_droid) == False:
                cargo_ship.push(container)
                container = node_stack.Stack()
            astromech_droid = droids.Droid("Astromech")
        else:
            install_part(protocol_droid, worker_belt, coworker_belt)
            if protocol_droid.is_complete():
                if pack(container, protocol_droid) == False:
                    cargo_ship.push(container)
                    container = node_stack.Stack()
                protocol_droid = droids.Droid("Protocol")
            if coworker_belt.size() > 0 and astromech_droid.is_complete() == False:
                install_part(astromech_droid, coworker_belt, worker_belt)
                if astromech_droid.is_complete():
                    if pack(container, astromech_droid) == False:
                        cargo_ship.push(container)
                        container = node_stack.Stack()
                    astromech_droid = droids.Droid("Astromech")
    return cargo_ship

def ship(cargo_ship):
    """
    unpacks the cargoship full of containers with droids inside, prints result
    """
    container_count = 1
    while cargo_ship.size() > 0:
        print("Unpacking shipping container #" + str(container_count) + "...")
        container = cargo_ship.pop()
        while container.size() > 0:
            print("  " , container.peek())
            container.pop()
        container_count += 1

def main():
    """
    Calls other functions, pytest purposes
    """
    worker_belt = array_queue.Queue()
    worker_belt = unload_shipment("parts_0010_0005.txt", worker_belt)
    coworker_belt = array_queue.Queue()
    cargo_ship = assemble_droids(worker_belt, coworker_belt)
    ship(cargo_ship)

if __name__ == "__main__":
    """
    Pytest purposes
    """
    main()