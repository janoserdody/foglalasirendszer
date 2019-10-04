package datalayer;

import common.Ugyfel;

public interface IDataService {
    boolean InsertUgyfel(Ugyfel ugyfel);
    Ugyfel GetUgyfel(int Id);
}
