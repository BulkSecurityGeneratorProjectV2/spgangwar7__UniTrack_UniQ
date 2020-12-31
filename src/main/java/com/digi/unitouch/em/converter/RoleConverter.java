package com.digi.unitouch.em.converter;
//package com.xStream;
//
//import com.thoughtworks.xstream.converters.Converter;
//import com.thoughtworks.xstream.converters.MarshallingContext;
//import com.thoughtworks.xstream.converters.UnmarshallingContext;
//import com.thoughtworks.xstream.io.HierarchicalStreamReader;
//import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
//
//public class RoleConverter implements Converter{
//
//	@Override
//	public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
//		// TODO Auto-generated method stub
//		Role roleType = (Role) arg0;
//		arg1.addAttribute("content-type", roleType.getContentType());
//		 arg1.setValue(roleType.getValue());
//
//	}
//
//	@Override
//	public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
//		// TODO Auto-generated method stub
//		Role roleType = new Role();
//		roleType.setContentType(arg0.getAttribute("content-type"));
//		roleType.setValue(arg0.getValue());
//		return roleType;
//	}
//
//	@Override
//	public boolean canConvert(Class arg0) {
//		// TODO Auto-generated method stub
//		return arg0.equals(Role.class);
//	}
//}
