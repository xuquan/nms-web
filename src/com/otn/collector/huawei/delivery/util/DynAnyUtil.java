package com.otn.collector.huawei.delivery.util;

import org.omg.CORBA.Any;
import org.omg.CORBA.TCKind;
import org.omg.DynamicAny.DynAnyFactory;
import org.omg.DynamicAny.DynArray;
import org.omg.DynamicAny.DynEnum;
import org.omg.DynamicAny.DynSequence;
import org.omg.DynamicAny.DynStruct;
import org.omg.DynamicAny.DynUnion;

import com.otn.collector.huawei.delivery.connection.CorbaConnection;

/**
 * parse any type to string
 * @author xuquan
 * 2014-6-2
 */
public class DynAnyUtil {
	private static DynAnyFactory factory = CorbaConnection.getInstance().getDynAnyFactory();
	 /**
     * parseAny
     *
     * @param any Any
     * @return String
     */
    public static String parseAny(Any any)
    {
        if( null==any ){
            return null;
        }
        StringBuffer result = new StringBuffer();
        try {
            switch (any.type().kind().value()) {
            case TCKind._tk_char:
                result.append(any.extract_char());
                break;
            case TCKind._tk_null:
                break;
            case TCKind._tk_boolean:
                result.append(any.extract_boolean());
                break;
            case TCKind._tk_short:
                result.append(any.extract_short());
                break;
            case TCKind._tk_long:
                result.append(any.extract_long());
                break;
            case TCKind._tk_double:
                result.append(any.extract_double());
                break;
            case TCKind._tk_float:
                result.append(any.extract_float());
                break;
            case TCKind._tk_octet:
            	result.append(any.extract_octet());
            	break;
            case TCKind._tk_ulong:
            	result.append(any.extract_ulong());
            	break;
            case TCKind._tk_string:
                result.append(any.extract_string());
                break;
            case TCKind._tk_enum:
            {
                DynEnum dynEnum = (DynEnum) factory.create_dyn_any(any);
                result.append(dynEnum.get_as_string());
                break;
            }
            case TCKind._tk_any:
            {
            	any=factory.create_dyn_any(any).get_any();
            	result.append(any);
                break;
            }
            case TCKind._tk_objref:
            {
            	result.append(any.extract_Object());
                break;
            }
                
            case TCKind._tk_struct:
            case TCKind._tk_except:
            {
                DynStruct dynstruct = (DynStruct) factory.create_dyn_any(any);
                org.omg.DynamicAny.NameValuePair[] members = dynstruct.get_members();
                result.append("{");
                for (int i = 0; i < members.length; i++) {
                    //result.append("[" + members[i].id + "=");
                	if(i>0){
                		result.append(" ");
                	}
                    result.append(members[i].id).append(" ").append(parseAny(members[i].value));
                }
                result.append("}");
                break;
            }
            case TCKind._tk_union:
                DynUnion dynunion = (DynUnion) factory.create_dyn_any(any);
                result.append(dynunion.member_name()).append(" ");
                result.append(parseAny(dynunion.member().to_any()));
                break;
            case TCKind._tk_sequence:
                DynSequence dynseq = (DynSequence) factory.create_dyn_any(any);
                Any[] contents = dynseq.get_elements();
                result.append("{");
                for (int i = 0; i < contents.length; i++){
                    result.append(parseAny(contents[i]));
                }
                result.append("}");
                break;
            case TCKind._tk_array:
                DynArray dynarray = (DynArray) factory.create_dyn_any(any);
                Any[] array_contents = dynarray.get_elements();
                result.append("{");
                for (int i = 0; i < array_contents.length; i++){
                    result.append(parseAny(array_contents[i]) ).append(" ");
                }
                result.append("}");
                break;
            default:
                result.append(any.type().kind().value());

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result.toString();
    }
}
