package edu.umb.cs681.hw01;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Car
{
    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCount;


    public Car(String make, String model, int mileage, int year, float price)
    {
        this.make = make;
        this.model = model;
        this.mileage =  mileage;
        this.year = year;
        this.price = price;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setMileage(int mileage)
    {
        this.mileage = mileage;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public int getMileage()
    {
        return mileage;
    }

    public int getYear()
    {
        return year;
    }

    public float getPrice()
    {
        return price;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(LinkedList<Car> cars) {
        for (Car car : cars) {
            if ((car.getYear() > this.getYear() &&
                    car.getMileage() >= this.getMileage() &&
                    car.getPrice() <= this.getPrice()) ||
                    (car.getYear() >= this.getYear() &&
                            car.getMileage() > this.getMileage() &&
                            car.getPrice() <= this.getPrice()) ||
                    (car.getYear() >= this.getYear() &&
                            car.getMileage() >= this.getMileage() &&
                            car.getPrice() < this.getPrice())) {
                dominationCount++;
            }
        }
    }
    
   public static void main(String[] args) {
	   
	   LinkedList<Car> carList = new LinkedList<Car>();
	   
	   carList.add(new Car("Toyota", "RAV4", 35000, 2018, 10000f));
	   carList.add(new Car("320i", "BMW", 40, 2018, 35000f));
	   carList.add(new Car("A3", "Audi", 30, 2021, 40000f));
	   carList.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
	   carList.add(new Car("Accord", "Honda", 50, 2016, 27000f));
	   carList.add(new Car("Accent", "Hyundai", 53, 2013, 15000f));
	   
	   
	   //Sorting by Year in Ascending Order
	   var orderYearByAscending = carList.stream()
			   .sorted((Car c1, Car c2) -> c1.getYear() - c2.getYear())
			   .collect(Collectors.toList());
	   System.out.println("Sorting by Year in Ascending Order");
	   orderYearByAscending.forEach(Car -> System.out.println(Car.getMake()));
	   
	   //Sorting by Year in Descending Order
	   var orderYearByDescending = carList.stream()
			   .sorted((Car c1, Car c2) -> c2.getYear() - c1.getYear())
			   .collect(Collectors.toList());
	   System.out.println("Sorting by Year in Descending Order");
	   orderYearByDescending.forEach(Car -> System.out.println(Car.getMake()));
	   
	   //High Year Cars
	   System.out.println("Print High Year Cars");
	   Map<Boolean, List<Car>> highYearGroupCar = carList.stream()
               .collect(Collectors.partitioningBy(car -> car.getYear() >= 2018));
	   highYearGroupCar.get(true).forEach(car -> System.out.println(car.getMake()));
	   
	   //Print High Year Cars Count
	   int highYearCarCount = highYearGroupCar.get(true).size();
	   System.out.println("Number of High Year Cars : " + highYearCarCount);
	   
	   //Average of High Year Cars
	   int sumHighYearCar = highYearGroupCar.get(true).stream()
			   .map((Car car) -> car.getYear())
			   .reduce(0,(sumTotal, year) -> sumTotal+year);
	   int averageHighYearCar = sumHighYearCar/highYearCarCount;
	   System.out.println("Average of High Year Cars: " + averageHighYearCar);
	   
	   
	   //Low Year Cars
	   System.out.println("Print Low Year Cars");
	   Map<Boolean, List<Car>> lowYearGroupCar = carList.stream()
               .collect(Collectors.partitioningBy(car -> car.getYear() < 2018));
	   lowYearGroupCar.get(true).forEach(car -> System.out.println(car.getMake()));
	   
	   //Print Low Year Cars Count
	   int lowYearCarCount = lowYearGroupCar.get(true).size();
	   System.out.println("Number of Low Year Cars Count: " + lowYearCarCount);
	   
	   //Average of Low Year Cars
	   int sumLowYearCar = lowYearGroupCar.get(true).stream()
			   .map((Car car) -> car.getYear())
			   .reduce(0,(sumTotal, year) -> sumTotal+year);
	   int averageLowYearCar = sumLowYearCar/lowYearCarCount;
	   System.out.println("Average of Low Year Cars: " + averageLowYearCar);

	   
	   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
	   
	   //Sorting by Price in Ascending Order
	   var orderPriceByAscending = carList.stream()
			   .sorted((Car c1, Car c2) -> Float.compare(c1.getPrice(), c2.getPrice()))
			   .collect(Collectors.toList());
	   System.out.println("Sorting by Price in Ascending Order");
	   orderPriceByAscending.forEach(Car -> System.out.println(Car.getMake()));
	   
	   //Sorting by Price in Descending Order
	   var orderPriceByDescending = carList.stream()
			   .sorted((Car c1, Car c2) -> Float.compare(c2.getPrice(), c1.getPrice()))
			   .collect(Collectors.toList());
	   System.out.println("Sorting by Price in Descending Order");
	   orderPriceByDescending.forEach(Car -> System.out.println(Car.getMake()));
	   
	   //High Price Cars
	   System.out.println("Print High Price Cars");
	   Map<Boolean, List<Car>> highPriceGroupCar = carList.stream()
               .collect(Collectors.partitioningBy(car -> car.getPrice() > 20000f));
	   highPriceGroupCar.get(true).forEach(car -> System.out.println(car.getMake()));
	   
	   //Print High Price Cars Count
	   int highPriceCarCount = highPriceGroupCar.get(true).size();
	   System.out.println("Number of High Price Cars Count: " + highPriceCarCount);
	   
	   //Average of High Price Cars
	   float sumHighPriceCar = highPriceGroupCar.get(true).stream()
			   .map((Car car) -> car.getPrice())
			   .reduce(0.0f,(sumTotal, price) -> sumTotal+price);
	   float averageHighPriceCar = sumHighPriceCar/highPriceCarCount;
	   System.out.println("Average of High Price Cars: " + averageHighPriceCar);
	   
	   //Low Price Cars
	   System.out.println("Print Low Price Cars");
	   Map<Boolean, List<Car>> lowPriceGroupCar = carList.stream()
               .collect(Collectors.partitioningBy(car -> car.getPrice() <= 20000f));
	   lowPriceGroupCar.get(true).forEach(car -> System.out.println(car.getMake()));
	   
	   //Print Low Price Cars Count
	   int lowPriceCarCount = lowPriceGroupCar.get(true).size();
	   System.out.println("Number of Low Price Cars Count: " + lowPriceCarCount);
	   
	   //Average of Low Price Cars
	   float sumLowPriceCar = lowPriceGroupCar.get(true).stream()
			   .map((Car car) -> car.getPrice())
			   .reduce(0.0f,(sumTotal, price) -> sumTotal+price);
	   float averageLowPriceCar = sumLowPriceCar/lowPriceCarCount;
	   System.out.println("Average of Low Price Cars: " + averageLowPriceCar);
	   
	   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

	   
	   //Sorting by Mileage in Ascending Order
	   var orderMileageByAscending = carList.stream()
			   .sorted((Car c1, Car c2) -> c1.getMileage() - c2.getMileage())
			   .collect(Collectors.toList());
	   System.out.println("Sorting by Mileage in Ascending Order");
	   orderMileageByAscending.forEach(Car -> System.out.println(Car.getMake()));
	   
	   //Sorting by Mileage in Descending Order
	   var orderMileageByDescending = carList.stream()
			   .sorted((Car c1, Car c2) -> c2.getMileage() - c1.getMileage())
			   .collect(Collectors.toList());
	   System.out.println("Sorting by Mileage in Descending Order");
	   orderMileageByDescending.forEach(Car -> System.out.println(Car.getMake()));
	   
	   //Print High Mileage Cars
	   System.out.println("Print High Mileage Cars");
	   Map<Boolean, List<Car>> highMileageGroupCar = carList.stream()
               .collect(Collectors.partitioningBy(car -> car.getMileage() >= 50));
	   highMileageGroupCar.get(true).forEach(car -> System.out.println(car.getMake()));
	   
	   //Print High Mileage Cars Count
	   int highMileageCarCount = highMileageGroupCar.get(true).size();
	   System.out.println("Number of High Mileage Cars Count: " + highMileageCarCount);
	   
	   //Average of High Mileage Cars
	   int sumHighMileageCar = highMileageGroupCar.get(true).stream()
			   .map((Car car) -> car.getMileage())
			   .reduce(0,(sumTotal, mileage) -> sumTotal+mileage);
	   int averageHighMileageCar = sumHighMileageCar/highMileageCarCount;
	   System.out.println("Average of High Mileage Cars: " + averageHighMileageCar);
	   
	   //Print Low Mileage Cars
	   System.out.println("Print Low Mileage Cars");
	   Map<Boolean, List<Car>> lowMileageGroupCar = carList.stream()
               .collect(Collectors.partitioningBy(car -> car.getMileage() < 50));
	   lowMileageGroupCar.get(true).forEach(car -> System.out.println(car.getMake()));
	   
	   //Print Low Mileage Cars Count
	   int lowMileageCarCount = lowMileageGroupCar.get(true).size();
	   System.out.println("Number of Low Mileage Cars Count: " + lowMileageCarCount);
	   
	   //Average of Low Mileage Cars
	   int sumLowMileageCar = lowMileageGroupCar.get(true).stream()
			   .map((Car car) -> car.getMileage())
			   .reduce(0,(sumTotal, mileage) -> sumTotal+mileage);
	   int averageLowMileageCar = sumLowMileageCar/lowMileageCarCount;
	   System.out.println("Average of Low Mileage Cars: " + averageLowMileageCar);
	   
	   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

	   for (Car car : carList) {
           car.setDominationCount(carList);
       }
	   
	   //Sorting by Domination in Ascending Order
	   var orderDominationByAscending = carList.stream()
			   .sorted((Car c1, Car c2) -> c1.getDominationCount() - c2.getDominationCount())
			   .collect(Collectors.toList());
	   System.out.println("Sorting by Domination in Ascending Order");
	   orderDominationByAscending.forEach(Car -> System.out.println(Car.getMake()));
	   
	   //Sorting by Domination in Descending Order
	   var orderDominationByDescending = carList.stream()
			   .sorted((Car c1, Car c2) -> c2.getDominationCount() - c1.getDominationCount())
			   .collect(Collectors.toList());
	   System.out.println("Sorting by Domination in Descending Order");
	   orderDominationByDescending.forEach(Car -> System.out.println(Car.getMake()));
	   
	   //Print High Domination Cars
	   System.out.println("Print High Domination Cars");
	   Map<Boolean, List<Car>> highDominationGroupCar = carList.stream()
               .collect(Collectors.partitioningBy(car -> car.getDominationCount() >= 1));
	   highDominationGroupCar.get(true).forEach(car -> System.out.println(car.getMake()));
	   
	   //Print High Domination Cars Count
	   int highDominationCarCount = highDominationGroupCar.get(true).size();
	   System.out.println("Number of High Domination Cars Count: " + highDominationCarCount);
	   
	   //Average of High Domination Cars
	   int sumHighDominationCar = highDominationGroupCar.get(true).stream()
			   .map((Car car) -> car.getDominationCount())
			   .reduce(0,(sumTotal, domination) -> sumTotal+domination);
	   int averageHighDominationCar = sumHighDominationCar/highDominationCarCount;
	   System.out.println("Average of High Domination Cars: " + averageHighDominationCar);
	   
	   //Print Low Domination Cars
	   System.out.println("Print Low Domination Cars");
	   Map<Boolean, List<Car>> lowDominationGroupCar = carList.stream()
               .collect(Collectors.partitioningBy(car -> car.getDominationCount() < 1));
	   lowDominationGroupCar.get(true).forEach(car -> System.out.println(car.getMake()));
	   
	   //Print Low Domination Cars Count
	   int lowDominationCarCount = lowDominationGroupCar.get(true).size();
	   System.out.println("Number of Low Domination Cars Count: " + lowDominationCarCount);
	   
	   //Average of High Domination Cars
	   int sumLowDominationCar = lowDominationGroupCar.get(true).stream()
			   .map((Car car) -> car.getDominationCount())
			   .reduce(0,(sumTotal, domination) -> sumTotal+domination);
	   int averageLowDominationCar = sumLowDominationCar/lowDominationCarCount;
	   System.out.println("Average of Low Domination Cars: " + averageLowDominationCar);
    
   }    
    
    
}