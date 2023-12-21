# Description of the App:
I have created an app which implements Item Inventory System.

## ThreadUnsafe:
It includes classes defining an unsafe item inventory and sales threads. The main class initializes the inventory, creates multiple sales threads, and updates the inventory concurrently, reflecting the available item quantities after a specific time interval.

## ThreadSafe:
It demonstrates a thread-safe item inventory, utilizing locks to ensure synchronized access to shared resources. Multiple sales threads concurrently interact with the inventory, updating quantities safely. The main class initializes the inventory and creates sales threads.

