package com.princess.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSales is a Querydsl query type for Sales
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSales extends EntityPathBase<Sales> {

    private static final long serialVersionUID = -330172678L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSales sales = new QSales("sales");

    public final EnumPath<CheckCondition.YorN> cmt = createEnum("cmt", CheckCondition.YorN.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final QMember salesId;

    public final QProduct salesNo;

    public final DatePath<java.util.Date> salesRegdate = createDate("salesRegdate", java.util.Date.class);

    public final StringPath thunderId = createString("thunderId");

    public final NumberPath<Long> traNo = createNumber("traNo", Long.class);

    public QSales(String variable) {
        this(Sales.class, forVariable(variable), INITS);
    }

    public QSales(Path<? extends Sales> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSales(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSales(PathMetadata metadata, PathInits inits) {
        this(Sales.class, metadata, inits);
    }

    public QSales(Class<? extends Sales> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.salesId = inits.isInitialized("salesId") ? new QMember(forProperty("salesId")) : null;
        this.salesNo = inits.isInitialized("salesNo") ? new QProduct(forProperty("salesNo"), inits.get("salesNo")) : null;
    }

}

