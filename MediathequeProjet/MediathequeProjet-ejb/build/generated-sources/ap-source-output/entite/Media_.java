package entite;

import entite.Emprunt;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T00:21:37")
@StaticMetamodel(Media.class)
public class Media_ { 

    public static volatile SingularAttribute<Media, String> categorie;
    public static volatile SingularAttribute<Media, String> titre;
    public static volatile SingularAttribute<Media, Integer> joursPret;
    public static volatile SingularAttribute<Media, String> description;
    public static volatile SingularAttribute<Media, String> annee;
    public static volatile SingularAttribute<Media, Integer> mediaId;
    public static volatile SingularAttribute<Media, Integer> stock;
    public static volatile CollectionAttribute<Media, Emprunt> empruntCollection;

}