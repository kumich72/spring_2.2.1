package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiseImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public void add(Car car) {
        carDao.add(car);
    }
}
