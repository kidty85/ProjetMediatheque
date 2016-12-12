package entite;

import entite.Emprunt;
import entite.Membre;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T00:21:37")
@StaticMetamodel(Blocage.class)
public class Blocage_ { 

    public static volatile SingularAttribute<Blocage, Integer> blocageId;
    public static volatile SingularAttribute<Blocage, Date> finBlocage;
    public static volatile SingularAttribute<Blocage, Emprunt> empruntId;
    public static volatile SingularAttribute<Blocage, Membre> membreId;

}