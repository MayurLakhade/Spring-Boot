package studentmanagement_system.demo4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentmanagement_system.demo4.Repository.BatchesRepository;
import studentmanagement_system.demo4.entity.Batches;
import studentmanagement_system.demo4.exception.BatchNotFoundException;
import studentmanagement_system.demo4.service.BatchesService;

@Service
public class BatchesServiceImpl implements BatchesService{

    @Autowired
	BatchesRepository brepo;
	
	@Override
	public Batches addbatch(Batches batches) {
		// TODO Auto-generated method stub
		return brepo.save(batches);
	}

	@Override
	public Batches getbatchDetail(int bid) {
		// TODO Auto-generated method stub
		return brepo.findById(bid).orElseThrow(()-> new BatchNotFoundException("Entered batch is not present"));
	}

	@Override
	public List<Batches> getAllbatches() {
		// TODO Auto-generated method stub
		return brepo.findAll();
	}
    
}
