package in.ineuron.beans;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@AllArgsConstructor(access=AccessLevel.PUBLIC)
//@EqualsAndHashCode
//@NoArgsConstructor(access=AccessLevel.PROTECTED)
//@ToString
//@RequiredArgsConstructor(access=AccessLevel.PRIVATE)
@Data
public class Student {
	//@NonNull
	private Integer sid;
	//@NonNull
	private String sname;
	private String saddress;
	private Integer sage;
}
