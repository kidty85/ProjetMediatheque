package entite;

import entite.Blocage;
import entite.Media;
import entite.Membre;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T00:21:37")
@StaticMetamodel(Emprunt.class)
public class Emprunt_ { 

    public static volatile SingularAttribute<Emprunt, Date> dateEmprunt;
    public static volatile CollectionAttribute<Emprunt, Blocage> blocageCollection;
    public static volatile SingularAttribute<Emprunt, Integer> empruntId;
    public static volatile SingularAttribute<Emprunt, Membre> membreId;
    public static volatile SingularAttribute<Emprunt, Media> mediaId;

}