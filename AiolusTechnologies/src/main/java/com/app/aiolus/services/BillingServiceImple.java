package com.app.aiolus.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.app.aiolus.constants.Constant;
import com.app.aiolus.entities.Billing;
import com.app.aiolus.entities.User;
import com.app.aiolus.models.BillingModel;
import com.app.aiolus.models.BillingResponseModel;
import com.app.aiolus.models.BillingResponseModelShowAll;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.repositories.BillingRepository;
import com.app.aiolus.repositories.UserRepository;

@Service
public class BillingServiceImple implements BillingService {

	@Autowired
	private BillingRepository billingRepositoryImpl;

	@Autowired
	private Converter<BillingModel, Billing> billingConverter;

	@Autowired
	private Converter<Billing, BillingModel> billingEntityToModelConverter;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData addBilling(BillingModel billingModel) {

		Billing billing = (Billing) billingConverter.convert(billingModel);
		User user = userRepository.getSingleUserIdUser(billingModel.getIdUser());
		billing.setUser(user);
		long id = billingRepositoryImpl.addBilling(billing).getId();
		if (id > Constant.ZERO) {
			return new ResponseData(billing.getId(), Constant.TRUE, Constant.SUCCESSFULL_ADDED);
		} else {
			return new ResponseData(Constant.ZERO, Constant.FALSE, Constant.FAILED_MESSAGE);
		}

	}

	@Override
	public ResponseData updateBilling(BillingModel billingModel) {

		Billing billing = billingConverter.convert(billingModel);
		billingRepositoryImpl.updateBilling(billing);
		User user = userRepository.getSingleUserIdUser(billingModel.getIdUser());
		billing.setUser(user);
		long id = billingRepositoryImpl.updateBilling(billing).getId();
		if (id > Constant.ZERO) {
			return new ResponseData(billing.getId(), Constant.TRUE, Constant.UPDATE_SUCCESSFULL_ADDED);
		} else {
			return new ResponseData(Constant.ZERO, Constant.FALSE, Constant.UPDATE_FAILED_MESSAGE);
		}

	}

	@Override
	public BillingResponseModel getBillingByIdUser(long idUser, int pageSize, int page) {

		BillingResponseModel billingResponseModel = new BillingResponseModel();
		Map<String, Object> map = billingRepositoryImpl.getBillingByIdUser(idUser, pageSize, page);
		billingResponseModel.setCount((long) map.get(Constant.COUNT));

		List<Billing> billing = (List<Billing>) map.get(Constant.DATA);

		List<BillingModel> billingList = billing.stream()
				.map(b -> new BillingModel(b.getId(), b.getAmount(), b.getDateTime(), b.getDescription(),
						b.getItemName(), b.getSiteId(), b.getUser().getIdUser(), b.getUser().getUserId()))
				.collect(Collectors.toList());

		/*
		 * new ArrayList<>(); billing.forEach(action -> { BillingModel billingModel =
		 * new BillingModel(); billingModel.setId(action.getId());
		 * billingModel.setAmount(action.getAmount());
		 * billingModel.setDateTime(action.getDateTime());
		 * billingModel.setDescription(action.getDescription());
		 * billingModel.setItemName(action.getItemName());
		 * billingModel.setSiteId(action.getSiteId());
		 * billingModel.setIdUser(action.getUser().getIdUser());
		 * billingModel.setUserId(action.getUser().getUserId());
		 * 
		 * billingList.add(billingModel); });
		 */

		billingResponseModel.setIdUser(idUser);
		billingResponseModel.setData(billingList);

		return billingResponseModel;

	}

	@Override
	public BillingResponseModelShowAll getAllBilling(int pageSize, int page) {

		BillingResponseModelShowAll billingResponseModel = new BillingResponseModelShowAll();
		Map<String, Object> map = billingRepositoryImpl.getAllBilling(pageSize, page);
		billingResponseModel.setCount((long) map.get(Constant.COUNT));
		List<Billing> billing = (List<Billing>) map.get(Constant.DATA);
		List<BillingModel> billingList = billing.stream()
				.map(b -> new BillingModel(b.getId(), b.getAmount(), b.getDateTime(), b.getDescription(),
						b.getItemName(), b.getSiteId(), b.getUser().getIdUser(), b.getUser().getUserId()))
				.collect(Collectors.toList());

//		new ArrayList<BillingModel>();
//		billing.forEach(action -> {
//
//			BillingModel billingModel = new BillingModel();
//			billingModel.setId(action.getId());
//			billingModel.setAmount(action.getAmount());
//			billingModel.setDateTime(action.getDateTime());
//			billingModel.setDescription(action.getDescription());
//			billingModel.setItemName(action.getItemName());
//			billingModel.setSiteId(action.getSiteId());
//			billingModel.setIdUser(action.getUser().getIdUser());
//			billingModel.setUserId(action.getUser().getUserId());
//
//			billingList.add(billingModel);
//
//		});

		billingResponseModel.setData(billingList);

		return billingResponseModel;

	}

	@Override
	public BillingModel getSingleBillingById(long id) {

		return billingEntityToModelConverter.convert(billingRepositoryImpl.getSingleBillingById(id));

	}

}
