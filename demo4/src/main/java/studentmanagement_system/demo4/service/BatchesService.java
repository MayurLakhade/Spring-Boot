package studentmanagement_system.demo4.service;

import java.util.List;

import studentmanagement_system.demo4.entity.Batches;

public interface BatchesService {

    Batches addbatch(Batches batches);
	
	Batches getbatchDetail(int bid);
	
	List<Batches> getAllbatches();
    
}
